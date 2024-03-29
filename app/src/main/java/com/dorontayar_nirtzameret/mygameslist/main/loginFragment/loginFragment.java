package com.dorontayar_nirtzameret.mygameslist.main.loginFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.dorontayar_nirtzameret.mygameslist.R;

public class loginFragment extends Fragment {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button registerButton;

    private LoginViewModel viewModel;

    public loginFragment() {
        // Required empty public constructor
    }
    public static loginFragment newInstance() {
        loginFragment fragment = new loginFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize UI components
        usernameEditText = view.findViewById(R.id.editTextUsername);
        passwordEditText = view.findViewById(R.id.editTextPassword);
        loginButton = view.findViewById(R.id.buttonLogin);
        registerButton = view.findViewById(R.id.buttonRegister);

        // Initialize ViewModel
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        // Setup click listener for login button
        loginButton.setOnClickListener(v -> loginUser());


        // Setup click listener for register button
        registerButton.setOnClickListener(v -> navigateToRegisterFragment());


        // Observe login result
        viewModel.isAuthenticated().observe(getViewLifecycleOwner(), isAuthenticated -> {
            if (isAuthenticated) {
                navigateToMainFragment();
                Log.w("user login", "login success");
            } else {
                Log.w("user login", "login fail");
            }
        });
    }



    private void loginUser() {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        viewModel.login(username, password);
    }

    private void navigateToMainFragment() {
        Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_mainFragment);
    }

    private void navigateToRegisterFragment() {
        //Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_registerFragment);
        Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_registerFragment);
    }
}

