using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;

namespace SiOps {
    [Activity(Label = "SiOps", MainLauncher = true, Icon = "@drawable/icon")]
    public class LoginActivity : Activity {
        protected override void OnCreate(Bundle bundle) {
            base.OnCreate(bundle);

            // Create your application here
            SetContentView(Resource.Layout.Login);

            // Get object from layout resource
            Button button = FindViewById<Button>(Resource.Id.btnLogin);
            EditText textUsername = FindViewById<EditText>(Resource.Id.txtUser);
            EditText textPassword = FindViewById<EditText>(Resource.Id.txtPassword);

            //Code:            
            //Button - Login
            button.Click += delegate {
                //Validate if all fields are filled
                if ((textUsername.Text != String.Empty) && (textPassword.Text != String.Empty)) {
                    //TODO: Validate if Username exists and if it does,
                    //TODO: validate if the inserted password is valid according to the data in the data base
                    StartActivity(typeof(MenuActivity));
                } else {
                    if (textUsername.Text == String.Empty && textPassword.Text == String.Empty) {
                        // Toast -- To notify in case all fields are empty
                        Toast.MakeText(this.BaseContext, "Os campos têm de estar preenchidos.", ToastLength.Short).Show();
                    }
                    else if (textUsername.Text == String.Empty && textPassword.Text != String.Empty) {
                        // Toast -- To notify in case Username is empty
                        Toast.MakeText(this.BaseContext, "O campo Utilizador tem de ser preenchido.", ToastLength.Short).Show();
                    }
                    else if (textPassword.Text == String.Empty && textUsername.Text != String.Empty) {
                        // Toast -- To notify in case Password is empty
                        Toast.MakeText(this.BaseContext, "O campo Password tem de ser preenchido.", ToastLength.Short).Show();
                    }
                }
            };
            
        }
    }
}