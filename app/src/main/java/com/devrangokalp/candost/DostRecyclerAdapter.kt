package com.devrangokalp.candost

import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import kotlinx.android.synthetic.main.tek_uye.view.*

class DostRecyclerAdapter(tumdostlar:ArrayList<Dost>): RecyclerView.Adapter<DostRecyclerAdapter.DostViewHolder>(),Filterable
{


    var doslarintumu=tumdostlar
    var myFilter:FilterHelper= FilterHelper(tumdostlar,this)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DostViewHolder {

        var inflater=LayoutInflater.from(parent.context)
        var tek_uye=inflater.inflate(R.layout.tek_uye,parent,false)
        return DostViewHolder(tek_uye)
    }

    override fun getItemCount(): Int {
        return doslarintumu.size
    }

    override fun onBindViewHolder(holder: DostViewHolder, position: Int) {
        var olusturulanDost=doslarintumu.get(position)
        holder.setData(olusturulanDost,position)
    }



    inner class DostViewHolder(tek_uye: View) :RecyclerView.ViewHolder(tek_uye) {

        var tekDostBilgisi=tek_uye as CardView
        var dostİsmi=tekDostBilgisi.tvDostAdi
        var dostResmi=tekDostBilgisi.imgDostResim


        fun setData(olusturulanDost:Dost,position: Int) {
            dostResmi.setImageResource(olusturulanDost.resim)
            dostİsmi.text=olusturulanDost.isim

            tekDostBilgisi.setOnClickListener {v ->
                Toast.makeText(tekDostBilgisi.context,"position : "+position + "dost ismi:" +olusturulanDost.isim,Toast.LENGTH_LONG).show()
                var intent=Intent(v.context,DetayActivity::class.java)
                intent.putExtra("adi:",olusturulanDost.isim)
                intent.putExtra("resim:",olusturulanDost.resim)

                v.context.startActivity(intent)

            }


        }

    }

    fun setFilter(arrayList: ArrayList<Dost>) {
    doslarintumu=arrayList
    }

    override fun getFilter(): Filter {

        return  myFilter

    }

  /* fun setFilter(aranilanlar:ArrayList<Dost>){
         doslarintumu=ArrayList<Dost>()
         doslarintumu.addAll(aranilanlar)
        notifyDataSetChanged()

    }
*/

}