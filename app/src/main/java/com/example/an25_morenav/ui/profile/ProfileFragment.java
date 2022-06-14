package com.example.an25_morenav.ui.profile;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.an25_morenav.R;
import com.example.an25_morenav.databinding.FragmentProfileBinding;
import com.example.an25_morenav.databinding.ProfileOptionsBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    ImageView iv;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        iv = binding.iv;

        binding.fab.setOnClickListener(v -> openBottomSheet());

        return root;
    }

    private void openBottomSheet() {
        BottomSheetDialog bsd = new BottomSheetDialog(getActivity());
        ProfileOptionsBinding optionsBinding = ProfileOptionsBinding.inflate(getLayoutInflater());
        bsd.setContentView(optionsBinding.getRoot()); // ui for bsd
        bsd.show(); // to make visible

        optionsBinding.fabCamera.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            cameraAction.launch(intent);
            bsd.dismiss();
        });

        optionsBinding.fabGallery.setOnClickListener(v -> {});

        optionsBinding.fabRemove.setOnClickListener(v -> {
            // write the code for changing the content for image variable
            iv.setImageDrawable(getContext().getDrawable(R.drawable.ic_baseline_account_circle_24));
            bsd.dismiss(); // to hide / invisible the bsd
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    ActivityResultLauncher<Intent> cameraAction = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK){
                    Bitmap bitmap = (Bitmap) result.getData().getBundleExtra("data").get("data");
                    iv.setImageBitmap(bitmap); // displaying the captured one
                }
            });
}