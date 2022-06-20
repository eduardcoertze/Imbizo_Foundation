package com.example.imbizo_foundation;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity {

    ImageView google_img;
    BeginSignInRequest signInRequest;
    private static final int REQ_ONE_TAP = 2;
    private boolean showOneTapUI = true;
    private SignInClient oneTapClient;
    private FirebaseAuth mAuth;

    public static final String SERVER_CLIENT_ID = "343589929977-5fof4mpkshdrumqsoij4lq6nqj039080.apps.googleusercontent.com";

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        google_img = findViewById(R.id.imgLogin_SignIn);
//
//        mAuth = FirebaseAuth.getInstance();
//
//        oneTapClient = Identity.getSignInClient(this);
//
//        signInRequest = BeginSignInRequest.builder()
//                .setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
//                        .setSupported(true)
//                        // Your server's client ID, not your Android client ID.
//                        .setServerClientId(SERVER_CLIENT_ID)
//                        // Only show accounts previously used to sign in.
//                        .setFilterByAuthorizedAccounts(true)
//                        .build()).build();
//        google_img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                signIn();
//            }
//        });
//
//
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final int[] countSign = {4};
        setContentView(R.layout.activity_login);
        //set screen orientation for activity to portrait only
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //loadDialogBar = new LoadDialogBar(this);
        //connect GUI components to variables
        google_img = findViewById(R.id.imgLogin_SignIn);
        //Constructor for Google sign in
        mAuth = FirebaseAuth.getInstance();
        //get client
        oneTapClient = Identity.getSignInClient(this);

        signInRequest = BeginSignInRequest.builder()
                .setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                        .setSupported(true)
                        // Your server's client ID, not your Android client ID.
                        .setServerClientId(SERVER_CLIENT_ID)
                        // Only show accounts previously used to sign in.
                        .setFilterByAuthorizedAccounts(false)
                        .build())
                .build();

        //Sign in button
        google_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check how many times the user tries to sign-in
                if (countSign[0] > 1) {
                    //Show sign accounts
                    signIn();
                    countSign[0]--;
                } else {
                    Toast.makeText(LoginActivity.this, "Cool down come back in 5 min.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void signIn() {

        oneTapClient.beginSignIn(signInRequest).addOnSuccessListener(this, new OnSuccessListener<BeginSignInResult>() {
            @Override
            public void onSuccess(BeginSignInResult beginSignInResult) {
                try {
                    startIntentSenderForResult(beginSignInResult.getPendingIntent().getIntentSender(), REQ_ONE_TAP,
                            null, 0, 0, 0);
                } catch (IntentSender.SendIntentException e) {
                    Log.e(TAG, "Couldn't start One Tap UI: " + e.getLocalizedMessage());
                }
            }
        }).addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // No saved credentials found. Launch the One Tap sign-up flow, or
                // do nothing and continue presenting the signed-out UI.
                Log.d(TAG, "sigInw" + e.getLocalizedMessage());
            }
        });
    }

//    private void signIn() {
//        //creates an intent which pops up the google sign in page.
//        //loadDialogBar.ShowDialog();
//        oneTapClient.beginSignIn(signInRequest).addOnSuccessListener(this, new OnSuccessListener<BeginSignInResult>() {
//            @Override
//            public void onSuccess(BeginSignInResult beginSignInResult) {
//               // loadDialogBar.HideDialog();
//                try {
//                    startIntentSenderForResult(beginSignInResult.getPendingIntent().getIntentSender(), REQ_ONE_TAP,
//                            null, 0, 0, 0);
//                } catch (IntentSender.SendIntentException e) {
//                    Log.e(TAG, "Couldn't start One Tap UI: " + e.getLocalizedMessage());
//                }
//            }
//        }).addOnFailureListener(this, new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                // No saved credentials found. Launch the One Tap sign-up flow, or
//                // do nothing and continue presenting the signed-out UI.
//                Log.d(TAG, "sigInw" + e.getLocalizedMessage());
//            }
//        });
//
//    }


//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        //Get login user
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if (currentUser != null) {
//            UpdateUI(currentUser);
//        }
//    }

    @Override
    protected void onStart() {
        super.onStart();
        //Get login user
        FirebaseUser currentUser = mAuth.getCurrentUser();

        //if null then no user loged in
        //else login the user and go to main activity
        if (currentUser != null) {
            UpdateUI(currentUser);
        }

    }

//  //method for activity completion
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        // loadDialogBar.ShowDialog();
//        super.onActivityResult(requestCode, resultCode, data);
//        //checks if the sign in activity is complete and successful
//        try {
//            String googleCredential = oneTapClient.getSignInCredentialFromIntent(data).getGoogleIdToken();
//            AuthCredential credential = GoogleAuthProvider.getCredential(googleCredential, null);
//            //here we are checking the Authentication Credential and checking the task is successful or not and display the message
//            //based on that.
//            mAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    if (task.isSuccessful()) {
//                        Toast.makeText(LoginActivity.this, "successful", Toast.LENGTH_LONG).show();
//                        //get signed in user
//                        FirebaseUser firebaseUser = mAuth.getCurrentUser();
//                        //update details and go to main activity
//                        UpdateUI(firebaseUser);
//                    } else {
//                        Toast.makeText(LoginActivity.this, "Failed!", Toast.LENGTH_LONG).show();
//                    }
//                }
//            });
//
//        } catch (ApiException e) {
//            e.printStackTrace();
//        }
//
//    }

    //method for activity completion
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // loadDialogBar.ShowDialog();
        super.onActivityResult(requestCode, resultCode, data);
        //checks if the sign in activity is complete and successful
        try {
            String googleCredential = oneTapClient.getSignInCredentialFromIntent(data).getGoogleIdToken();
            AuthCredential credential = GoogleAuthProvider.getCredential(googleCredential, null);
            //here we are checking the Authentication Credential and checking the task is successful or not and display the message
            //based on that.
            mAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        //Toast.makeText(IntroWelcome.this, "successful", Toast.LENGTH_LONG).show();
                        //get signed in user
                        FirebaseUser firebaseUser = mAuth.getCurrentUser();
                        //update details and go to main activity
                        UpdateUI(firebaseUser);
                    } else {
                       // Toast.makeText(IntroWelcome.this, "Failed!", Toast.LENGTH_LONG).show();
                    }
                }
            });

        } catch (ApiException e) {
            e.printStackTrace();
        }

    }

    private void UpdateUI(FirebaseUser firebaseUser) {

        if (firebaseUser != null) {
            //userID
            String id = firebaseUser.getUid();
            //Username
            String personName = firebaseUser.getDisplayName();
            //Email address
            String personEmail = firebaseUser.getEmail();
            //profile picture
            Uri personPhoto = firebaseUser.getPhotoUrl();
            //check if user has profile picture
//            if (personPhoto == null) {
//                personPhoto = Uri.parse(DEFUALT_IMAGE);
//            }
            //Update user details
            //UserDetails user = new UserDetails(personName, " ", "personFamilyName", personEmail, id, personPhoto.toString());
            //Store user basic details in runtime
            //CurrentUser.currentUserObj = user;
            // TODO: 2022/05/25 Take out later
            //Toast.makeText(IntroWelcome.this, personName + "  " + personEmail, Toast.LENGTH_LONG).show();

            //Go to main activity
            Intent i = new Intent(LoginActivity.this, HomePage.class);
            startActivity(i);
            finish();
        }
    }
}