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
    [Activity(Label = "Detalhes da Operação")]
    public class DetalhesOperacaoActivity : Activity {
        protected override void OnCreate(Bundle bundle) {
            base.OnCreate(bundle);

            // Create your application here
            SetContentView(Resource.Layout.DetalhesOperacao);

            // Get objects from layout
            TextView txtNameOper = FindViewById<TextView>(Resource.Id.txtNameOper);
            TextView txtLimit = FindViewById<TextView>(Resource.Id.txtLimit);
            TextView txtType = FindViewById<TextView>(Resource.Id.txtType);
            // Set Objects
            txtNameOper.Text = Intent.GetStringExtra("Nome") ?? "Não disponivel";
            txtLimit.Text = "0";
            txtType.Text = "Tipo";
        }
    }
}