package me.dio.simulator.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import me.dio.simulator.databinding.MatchItemBinding
import me.dio.simulator.domain.Match

class MatchesAdapterK () :
    RecyclerView.Adapter<MatchesAdapter.ViewHolder>()  {

    private var matches:List<Match> = TODO()

    constructor(matches:List<Match>) : this() {
        this.matches=matches
    }

    class ViewHolder(binding: MatchItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MatchItemBinding.inflate((layoutInflater))
        return  MatchesAdapter.ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MatchesAdapter.ViewHolder, position: Int) {
        val match = matches.get(position)
        val context = holder.itemView.context

        //adapta os dados da partida(recuperado da API para o nosso layout)
        Glide.with(context).load(match.awayTeam).circleCrop().into(holder.binding.ivHomeTeam)
        Glide.with(context).load(match.awayTeam.image).circleCrop().into(holder.binding.ivAwayTeam)
        holder.binding.tvHomeTeamName.setText(match.homeTeam.name)
        holder.binding.tvAwayTeamName.setText(match.awayTeam.name)
    }

    override fun getItemCount(): Int {
        return matches.size
    }

}
