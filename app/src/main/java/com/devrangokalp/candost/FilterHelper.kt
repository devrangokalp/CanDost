package com.devrangokalp.candost

import android.widget.Filter

class FilterHelper(tumDostlar:ArrayList<Dost>,adapter:DostRecyclerAdapter):Filter() {

    var suankiTumDostlar=tumDostlar
    var suankiAdapter=adapter


    override fun performFiltering(constraint: CharSequence?): FilterResults {
        var sonuc=FilterResults()

        if (constraint!=null && constraint.length>0)
        {
            var aranilanAd=constraint.toString().toLowerCase()
            var eslesenAd=ArrayList<Dost>()

            for (dost in suankiTumDostlar)
            {

                if (dost.isim.toLowerCase().contains(aranilanAd.toString()))
                {
                    eslesenAd.add(dost)
                }
            }
            sonuc.values=eslesenAd
            sonuc.count=eslesenAd.size
        }
        else
        {
            sonuc.values = suankiTumDostlar
            sonuc.count = suankiTumDostlar.size
        }

        return sonuc
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

        suankiAdapter.setFilter(results?.values as ArrayList<Dost>)
        suankiAdapter.notifyDataSetChanged()
    }
}