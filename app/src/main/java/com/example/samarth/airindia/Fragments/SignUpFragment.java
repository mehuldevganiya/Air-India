package com.example.samarth.airindia.Fragments;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.samarth.airindia.R;

/**
 * Created by samarth on 23/12/15.
 */
public class SignUpFragment extends Fragment implements RadioButton.OnClickListener {
    private EditText inputFirstName,inputLastName,inputEmail, inputPassword;
    private TextInputLayout  inputLayoutFirstName,inputLayoutLastName,inputLayoutEmail, inputLayoutPassword;
    private Button btnSignUp;
    public SignUpFragment()
    {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.signup_fragment, container, false);

        v.findViewById(R.id.radio_female).setOnClickListener(this);
        v.findViewById(R.id.radio_male).setOnClickListener(this);


        inputLayoutFirstName=(TextInputLayout)v.findViewById(R.id.input_layout_firstName);
        inputLayoutLastName=(TextInputLayout)v.findViewById(R.id.input_layout_lastName);
        inputLayoutEmail = (TextInputLayout) v.findViewById(R.id.input_layout_email);
        inputLayoutPassword = (TextInputLayout) v.findViewById(R.id.input_layout_password);

        inputFirstName=(EditText)v.findViewById(R.id.input_firstName);
        inputLastName=(EditText)v.findViewById(R.id.input_lastName);
        inputEmail = (EditText) v.findViewById(R.id.input_email);
        inputPassword = (EditText) v.findViewById(R.id.input_password);
        btnSignUp = (Button) v.findViewById(R.id.btn_signup);

        inputFirstName.addTextChangedListener(new MyTextWatcher(inputFirstName));
        inputLastName.addTextChangedListener(new MyTextWatcher(inputLastName));
        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
        return v;
    }
    private void submitForm() {
        if (!validateFirstName()) {
            return;
        }

        if (!validateLastName()) {
            return;
        }


        if (!validateEmail()) {
            return;
        }

        if (!validatePassword()) {
            return;
        }
        /* Call the web services for registering a new user*/
        Toast.makeText(getActivity().getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
    }

    private boolean validateFirstName() {
        if (inputFirstName.getText().toString().trim().isEmpty()) {
            inputLayoutFirstName.setError(getString(R.string.err_msg_first_name));
            requestFocus(inputFirstName);
            return false;
        } else {
            inputLayoutFirstName.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validateLastName() {
        if (inputLastName.getText().toString().trim().isEmpty()) {
            inputLayoutLastName.setError(getString(R.string.err_msg_last_name));
            requestFocus(inputLastName);
            return false;
        } else {
            inputLayoutLastName.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateEmail() {
        String email = inputEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            inputLayoutEmail.setError(getString(R.string.err_msg_email));
            requestFocus(inputEmail);
            return false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePassword() {
        if (inputPassword.getText().toString().trim().isEmpty()) {
            inputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(inputPassword);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        boolean checked = ((RadioButton) v).isChecked();

        // Check which radio button was clicked
        switch(v.getId()) {
            case R.id.radio_male:
                if (checked)
                    Log.i("RadioButtonSelected","Male");
                break;
            case R.id.radio_female:
                if (checked)
                    Log.i("RadioButtonSelected","Female");

                break;
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_firstName:
                    validateFirstName();
                    break;
                case R.id.input_lastName:
                    validateLastName();
                    break;
                case R.id.input_email:
                    validateEmail();
                    break;
                case R.id.input_password:
                    validatePassword();
                    break;
            }
        }
    }
    /*
    public void onRadioButtonClicked(View view)
    {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_male:
                if (checked)
                    Log.i("RadioButtonSelected","Male");
                    break;
            case R.id.radio_female:
                if (checked)
                    Log.i("RadioButtonSelected","Female");

                    break;
        }
    }*/

}
