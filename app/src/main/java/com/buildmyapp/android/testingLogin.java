package com.buildmyapp.android;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.auth0.android.Auth0;
import com.auth0.android.authentication.AuthenticationException;
import com.auth0.android.provider.AuthCallback;
import com.auth0.android.provider.WebAuthProvider;
import com.auth0.android.result.Credentials;
import com.buildmyapp.android.BottomNavFragments.BottomNavigation;

public class testingLogin extends Activity {

    private TextView token;
    private Auth0 auth0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_login);

        token = (TextView) findViewById(R.id.token);
        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        auth0 = new Auth0(this);
        auth0.setOIDCConformant(true);
    }





    private void login() {
        token.setText("Not logged in");
        WebAuthProvider.init(auth0)
                .withScheme("demo")
                .withAudience(String.format("https://%s/userinfo", getString(R.string.com_auth0_domain)))
                .start(testingLogin.this, new AuthCallback() {
                    @Override
                    public void onFailure(@NonNull final Dialog dialog) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                dialog.show();
                            }
                        });
                    }

                    @Override
                    public void onFailure(final AuthenticationException exception) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(testingLogin.this, "Error: " + exception.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onSuccess(@NonNull final Credentials credentials) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                token.setText("Logged in: " + credentials.getAccessToken());
                            }
                        });

                        startActivity(new Intent(testingLogin.this, BottomNavigation.class));
                    }





                });
    }
    }



