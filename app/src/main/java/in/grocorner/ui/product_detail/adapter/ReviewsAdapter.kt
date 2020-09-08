package `in`.grocorner.ui.product_detail.adapter

import `in`.grocorner.R
import `in`.grocorner.ui.product_detail.model.ReviewsModel
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReviewsAdapter(val context: Context, private val reviewsList: List<ReviewsModel>) :
    RecyclerView.Adapter<ReviewsVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsVH {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_review, parent, false)
        return ReviewsVH(view)
    }

    override fun getItemCount() = reviewsList.size

    override fun onBindViewHolder(holder: ReviewsVH, position: Int) {
        val reviewsHolder = holder as ReviewsVH
        reviewsHolder.apply {
            reviewsPersonName.text = reviewsList[position].reviewPersonName
            reviewsContent.text = reviewsList[position].reviewContent
            ratingBar.rating = reviewsList[position].rating
        }
    }
}

class ReviewsVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val reviewsPersonName: TextView = itemView.findViewById(R.id.reviews_person_name_tv)
    val reviewsContent: TextView = itemView.findViewById(R.id.reviews_content_tv)
    val ratingBar: RatingBar = itemView.findViewById(R.id.reviews_rating)
}