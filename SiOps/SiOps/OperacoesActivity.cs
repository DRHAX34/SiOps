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
    [Activity(Label = "OperacoesActivity")]
    public class OperacoesActivity : Activity {
        protected override void OnCreate(Bundle bundle) {
            base.OnCreate(bundle);

            // Create your application here
            SetContentView(Resource.Layout.Operacoes);

            // Get objects from layout
            ListView listOperacoes = FindViewById<ListView>(Resource.Id.listViewOperacoes);

            //TODO:Fill Opera��es list
            var itemsOperacoes = new List<string>() { "Opera��o 1", "Opera��o 2", "Opera��o 3" };
            var adapterOperacoes = new ArrayAdapter<string>(this, Android.Resource.Layout.SimpleSpinnerItem, itemsOperacoes);
            listOperacoes.Adapter = adapterOperacoes;

            //Code listview item click
            listOperacoes.ItemClick += delegate {
                //Go to ColaboradorDetalhes
                StartActivity(typeof(DetalhesOperacaoActivity));
            };

        }
    }
}