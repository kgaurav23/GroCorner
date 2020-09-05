package `in`.grocorner.ui.utility

import `in`.grocorner.R
import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.ImageView
import com.bumptech.glide.Glide

object ImageUtility {

    fun showImageUsingBitmap(
        context: Context,
        bitmap: Bitmap,
        view: ImageView,
        placeholderImage: Int = R.drawable.ic_delivery
    ) {
        Glide
            .with(context)
            .load(bitmap)
            .placeholder(placeholderImage)
            .into(view)
    }

    fun showImageFromUrl(
        context: Context,
        url: String,
        view: ImageView,
        placeholderImage: Int = R.drawable.ic_delivery
    ) {
        Glide
            .with(context)
            .load(url)
            //.centerCrop()
            .placeholder(placeholderImage)
            .into(view)
    }

    fun showImageFromFile(
        context: Context,
        filePath: String,
        view: ImageView,
        reqWidth: Int = 180,
        reqHeight: Int = 180,
        placeholderImage: Int = R.drawable.ic_delivery
    ) {
        val compressedBitmap: Bitmap = decodeSampledBitmapFromFile(filePath, reqWidth, reqHeight)

        Glide
            .with(context)
            .load(compressedBitmap)
            .placeholder(placeholderImage)
            .into(view)
    }

    private fun calculateInSampleSize(
        options: BitmapFactory.Options,
        reqWidth: Int,
        reqHeight: Int
    ): Int {
        // Raw height and width of image
        val (height: Int, width: Int) = options.run { outHeight to outWidth }
        var inSampleSize = 1

        if (height > reqHeight || width > reqWidth) {

            val halfHeight: Int = height / 2
            val halfWidth: Int = width / 2

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while (halfHeight / inSampleSize >= reqHeight && halfWidth / inSampleSize >= reqWidth) {
                inSampleSize *= 2
            }
        }

        return inSampleSize
    }

    fun decodeSampledBitmapFromResource(
        res: Resources,
        resId: Int,
        reqWidth: Int,
        reqHeight: Int
    ): Bitmap {
        // First decode with inJustDecodeBounds=true to check dimensions
        return BitmapFactory.Options().run {
            inJustDecodeBounds = true
            BitmapFactory.decodeResource(res, resId, this)

            // Calculate inSampleSize
            inSampleSize = calculateInSampleSize(this, reqWidth, reqHeight)

            // Decode bitmap with inSampleSize set
            inJustDecodeBounds = false

            BitmapFactory.decodeResource(res, resId, this)
        }
    }

    private fun decodeSampledBitmapFromFile(
        filePath: String,
        reqWidth: Int,
        reqHeight: Int
    ): Bitmap {
        // First decode with inJustDecodeBounds=true to check dimensions
        return BitmapFactory.Options().run {
            inJustDecodeBounds = true
            BitmapFactory.decodeFile(filePath, this)

            // Calculate inSampleSize
            inSampleSize = calculateInSampleSize(this, reqWidth, reqHeight)

            // Decode bitmap with inSampleSize set
            inJustDecodeBounds = false

            BitmapFactory.decodeFile(filePath, this)
        }
    }
}