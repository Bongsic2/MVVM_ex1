package org.techtown.mvvm;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import org.techtown.mvvm.databinding.ActivityMainBinding;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding; // 상속 ViewDataBinding
    ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main); // Activity Content's View - Layout 연결 & 반환 : ViewDataBinding을 상속하는 제네릭 타입

        viewModel = new ViewModel(Database.getInstance());
        binding.setViewModel(viewModel);

        binding.okBtnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.getUser();
            }
        });
    }
}