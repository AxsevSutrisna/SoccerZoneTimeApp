package com.example.myrecyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecyclerview.R.id.tv_detail_name
import de.hdodenhof.circleimageview.CircleImageView

class ListPlayerAdapter(val listPlayer: ArrayList<Player>) :
    RecyclerView.Adapter<ListPlayerAdapter.ListViewHolder>() {


    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgPhoto: CircleImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvFullName: TextView? = itemView.findViewById(tv_detail_name)
        val tvPlayerNationality: TextView = itemView.findViewById(R.id.tv_player_nationallity)
        val imgFlag: ImageView = itemView.findViewById(R.id.img_flags)
        val imgClub: ImageView = itemView.findViewById(R.id.img_club)
        val tvClub: TextView = itemView.findViewById(R.id.tv_player_clubs)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_row_player, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listPlayer.size


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, fullName, playerNationality, playerClubName, height, weight, description, flag, club, photo) = listPlayer[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvPlayerNationality.text = playerNationality
        holder.tvClub.text = playerClubName
        holder.imgClub.setImageResource(club)
        holder.imgFlag.setImageResource(flag)

        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "You Choose " + listPlayer[holder.adapterPosition].name,
                Toast.LENGTH_SHORT
            ).show()
            val intentDetail = Intent(holder.itemView.context, DetailPlayer::class.java)
            intentDetail.putExtra(
                MainActivity.INTENT_PARCELABLE,
                listPlayer[holder.adapterPosition]
            )
            holder.itemView.context.startActivity(intentDetail)
        }

        /*holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_hero", listHero[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }*/


    }

}


