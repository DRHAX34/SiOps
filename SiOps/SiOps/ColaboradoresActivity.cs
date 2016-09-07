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
    [Activity(Label = "ColaboradoresActivity")]
    public class ColaboradoresActivity : Activity {
        protected override void OnCreate(Bundle bundle) {
            base.OnCreate(bundle);

            // Create your application here
            SetContentView(Resource.Layout.Colaboradores);

            // Get objects from layout
            ListView listColaboradores = FindViewById<ListView>(Resource.Id.listViewColaboradores);
            
            //Code
            //TODO:Fill list
            var itemsColaboradores = new List<string>() { "Colaborador A", "Colaborador B", "Colaborador C" };
            var adapterColaboradores = new ArrayAdapter<string>(this, Android.Resource.Layout.SimpleSpinnerItem, itemsColaboradores);
            listColaboradores.Adapter = adapterColaboradores;

            //Code listview item click
            listColaboradores.ItemClick += delegate {
                //Go to ColaboradorDetalhes
                StartActivity(typeof(DetalhesColaboradorActivity));
            };
        }
    }
}