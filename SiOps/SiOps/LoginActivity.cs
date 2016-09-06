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
    [Activity(Label = "LoginActivity", MainLauncher = true, Icon = "@drawable/icon")]
    public class LoginActivity : Activity {
        protected override void OnCreate(Bundle bundle) {
            base.OnCreate(bundle);

            // Create your application here
            SetContentView(Resource.Layout.Login);

            // Get object from layout resource
            Button button = FindViewById<Button>(Resource.Id.btnLogin);

            //Code
            //Go to Menu
            button.Click += delegate {
                StartActivity(typeof(MenuActivity));
            };

        }
    }
}