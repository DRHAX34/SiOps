package md5b19cf8eb26938d2f86dcd0d096839a43;


public class DetalhesColaboradorActivity
	extends android.app.Activity
	implements
		mono.android.IGCUserPeer
{
	static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\n" +
			"";
		mono.android.Runtime.register ("SiOps.DetalhesColaboradorActivity, SiOps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", DetalhesColaboradorActivity.class, __md_methods);
	}


	public DetalhesColaboradorActivity () throws java.lang.Throwable
	{
		super ();
		if (getClass () == DetalhesColaboradorActivity.class)
			mono.android.TypeManager.Activate ("SiOps.DetalhesColaboradorActivity, SiOps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new java.lang.Object[] {  });
	}


	public void onCreate (android.os.Bundle p0)
	{
		n_onCreate (p0);
	}

	private native void n_onCreate (android.os.Bundle p0);

	java.util.ArrayList refList;
	public void monodroidAddReference (java.lang.Object obj)
	{
		if (refList == null)
			refList = new java.util.ArrayList ();
		refList.add (obj);
	}

	public void monodroidClearReferences ()
	{
		if (refList != null)
			refList.clear ();
	}
}
