package view.turingrobot.com.myturingrobot.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

public class ProcessImageTask extends AsyncTask<Void, Void, Bitmap> {
    private IImageFilter filter;
    private Activity activity = null;
    private Drawable imgPic;
    CallBack mCallBack ;


    public ProcessImageTask(Activity activity, IImageFilter imageFilter,Drawable imgPic) {
        this.filter = imageFilter;
        this.activity = activity;
        this.imgPic = imgPic;
    }

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
    }

    public Bitmap doInBackground(Void... params) {
        Image img = null;
        try {
            Bitmap bitmap = drawableToBitmap(imgPic);
        	Bitmap scbit = Bitmap.createScaledBitmap(bitmap,360,239,true) ;
            img = new Image(scbit);
            if (filter != null) {
                img = filter.process(img);
                img.copyPixelsFromBuffer();
            }
            return img.getImage();
        } catch (Exception e) {
            if (img != null && img.destImage.isRecycled()) {
                img.destImage.recycle();
                img.destImage = null;
                System.gc(); // 提醒系统及时回收
            }
        } finally {
            if (img != null && img.image.isRecycled()) {
                img.image.recycle();
                img.image = null;
                System.gc(); // 提醒系统及时回收
            }
        }
        return null;
    }
    
    public Bitmap drawableToBitmap(Drawable drawable) {
		int width = drawable.getIntrinsicWidth();
		int height = drawable.getIntrinsicHeight();
		Bitmap bitmap = Bitmap.createBitmap(width, height, drawable
				.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
				: Bitmap.Config.RGB_565);
		Canvas canvas = new Canvas(bitmap);
		drawable.setBounds(0, 0, width, height);
		drawable.draw(canvas);
		return bitmap;

	}
    
    
    @Override
    protected void onPostExecute(Bitmap result) {
        if (result != null) {
            super.onPostExecute(result);
            if(mCallBack !=null){
                mCallBack.complete(result);
            }
        }
    }

    public void setCallBack(CallBack mCallBack) {
        this.mCallBack = mCallBack;
    }

    public interface CallBack{
        void complete(Bitmap bitmap) ;
    }
}