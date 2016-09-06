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
    [Activity(Label = "MenuActivity")]
    public class MenuActivity : Activity {
        protected override void OnCreate(Bundle bundle) {
            base.OnCreate(bundle);

            // Create your application here
            SetContentView(Resource.Layout.Menu);

            // Get object from layout resource
            Button buttonColaboradores = FindViewById<Button>(Resource.Id.btnColaboradores);
            Button buttonOperacoes = FindViewById<Button>(Resource.Id.btnOperacoes);

            //Code
            //Go to Colaboradores
            buttonColaboradores.Click += delegate {
                StartActivity(typeof(ColaboradoresActivity));
            };

            //Go to Operações
            buttonOperacoes.Click += delegate {
                StartActivity(typeof(OperacoesActivity));
            };

        }
    }
}