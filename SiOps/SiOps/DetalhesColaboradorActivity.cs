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
    [Activity(Label = "Detalhes do Colaborador")]
    public class DetalhesColaboradorActivity : Activity {
        protected override void OnCreate(Bundle bundle) {
            base.OnCreate(bundle);

            // Create your application here
            SetContentView(Resource.Layout.DetalhesColaborador);
            // Get objects from layout
            ImageView imgPhoto = FindViewById<ImageView>(Resource.Id.imgPhoto);
            TextView txtName = FindViewById<TextView>(Resource.Id.txtName);
            TextView txtLocation = FindViewById<TextView>(Resource.Id.txtLocation);

            // Set Objects
            imgPhoto.SetImageResource(Resource.Drawable.smile);
            txtName.Text = Intent.GetStringExtra("Nome") ?? "Não disponivel";
            txtLocation.Text = "Localização";
        }
    }
}