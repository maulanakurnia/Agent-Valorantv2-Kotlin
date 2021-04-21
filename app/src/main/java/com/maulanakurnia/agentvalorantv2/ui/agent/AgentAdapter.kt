package com.maulanakurnia.agentvalorantv2.ui.agent

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.maulanakurnia.agentvalorantv2.R
import com.maulanakurnia.agentvalorantv2.model.AgentModel
import com.maulanakurnia.agentvalorantv2.ui.DetailAgentActivity
import kotlinx.android.synthetic.main.item_list_agent.view.*

class AgentAdapter(val activity: Activity): RecyclerView.Adapter<AgentAdapter.ViewHolder>() {

    private var listAgent = arrayListOf<AgentModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_agent, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listAgent.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listAgent[position])
    }

    fun getData(): List<AgentModel> = listAgent

    fun setData(courseItems: List<AgentModel>) {
        listAgent.clear()
        listAgent.addAll(courseItems)
    }

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

        fun bind(agent: AgentModel) {
            with(view) {

                Glide.with(this.context)
                    .load(agent.image)
                    .apply(RequestOptions().override(350, 550))
                    .into(agent_image)

                agent_name.text = agent.name
                agent_role.text = agent.role
                agent_summary.text = agent.summary

                view.btnPreview.setOnClickListener {
                    val i = Intent(activity, DetailAgentActivity::class.java)
                    i.putExtra("IMAGE_KEY", agent.image)
                    i.putExtra("NAME_KEY", agent.name)
                    i.putExtra("ROLE_KEY", agent.role)
                    i.putExtra("SUMMARY_KEY", agent.summary)
                    activity.startActivity(i)
                }

            }
        }
    }
}
