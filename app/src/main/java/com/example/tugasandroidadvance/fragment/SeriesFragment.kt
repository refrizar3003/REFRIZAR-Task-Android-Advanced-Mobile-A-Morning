package com.example.tugasandroidadvance.fragment

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.tugasandroidadvance.activity.MainActivity
import com.example.tugasandroidadvance.activity.MainActivity2
import com.example.tugasandroidadvance.adapter.ExploreAdapter
import com.example.tugasandroidadvance.adapter.ItemEvents
import com.example.tugasandroidadvance.data.ItemPost
import com.example.tugasandroidadvance.databinding.DialogAddItemBinding
import com.example.tugasandroidadvance.databinding.FragmentSeriesBinding

class SeriesFragment : Fragment(), ItemEvents {

    lateinit var binding: FragmentSeriesBinding
    lateinit var myAdapter: ExploreAdapter
    lateinit var othersCloneList: ArrayList<ItemPost>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSeriesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        othersCloneList = (requireActivity() as MainActivity).getData()
            .filter { it.showSeries } as ArrayList<ItemPost>

        val dataOthers = arrayListOf(

            ItemPost(
                "https://static.wikia.nocookie.net/doraemon/images/b/b3/New_doraemon_2005.jpg/revision/latest?cb=20230918013716&path-prefix=en",
                "Doraemon (2005 anime)",
                "Series 2005",
                "The 2005 Doraemon anime is the current anime TV series of Doraemon based on Fujiko F. Fujio's manga of the same name. It's produced by Shin-Ei Animation and Asatsu-DK, it began airing on TV Asahi on April 15, 2005. This Doraemon anime series is sometimes referred to in Asia as the Mizuta Edition (水田版), after Wasabi Mizuta, the voice actress who voices Doraemon in this series.\n" +
                        "\n" +
                        "The series first started airing in Japan on April 15th, 2005 (nearly 1 month after the 1979 anime ended) on TV Asahi. Produced by by Shin-Ei Animation, it is the successor to the 1979 anime. This anime currently runs successfully in many countries.",
                false,
                "", false, false, true
            ),

            ItemPost(
                "https://static.wikia.nocookie.net/doraemon/images/d/d7/%E3%83%89%E3%83%A9%E3%81%88%E3%82%82%E3%82%93_%281979%29_-_Poster.jpg/revision/latest?cb=20230907234429&path-prefix=en",
                "Doraemon (1979 anime)",
                "Series 1979",
                "Doraemon was a 1979 anime created by Fujiko F. Fujio. The series was produced by Shin-Ei Animation, and was more successful than its 1973 predecessor. It ran on TV Asahi from April 2, 1979 to March 25, 2005 for a total of 1,787 episodes and 30 specials. This anime adaption has now been dubbed in several languages, which aired in several countries.\n" +
                        "For the first 2 years of the series' run, the episodes (of approximately 6 minutes long) aired every Monday through Saturday from 6:50 to 7:00 PM. Starting October 2, 1981 the series switched to a weekly half-hour format, where it remained until the end of its run.[1] Because of the switch to the half-hour format, the episode length increased to 10 minutes, or sometimes 23 minutes. When the episodes were not 23 minutes, the network paired 2 shorter episodes (a new episode and a rerun) to fill up the half-hour time-slot.",
                false,
                "", false, false, true
            )
        )
        myAdapter = ExploreAdapter(othersCloneList, this)
        binding.recyclerOthers.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.recyclerOthers.adapter = myAdapter


        if ((requireActivity() as MainActivity).isWriter()) {
            binding.fabAddItem.show()
        }

        binding.fabAddItem.setOnClickListener {

            val alertDialog = AlertDialog.Builder(context).create()
            val dialogAddItemBinding = DialogAddItemBinding.inflate(layoutInflater)
            alertDialog.setView(dialogAddItemBinding.root)
            alertDialog.setCancelable(true)
            alertDialog.show()

            dialogAddItemBinding.btnAdd.setOnClickListener {

                if (dialogAddItemBinding.dialogAddEdtTitle.length() > 0 && dialogAddItemBinding.dialogEdtSubtitle.length() > 0 && dialogAddItemBinding.dialogAddEdtDetail.length() > 0 && dialogAddItemBinding.dialogAddEdtUrl.length() > 0) {
                    val txtTitle = dialogAddItemBinding.dialogAddEdtTitle.text.toString()
                    val txtSubtitle = dialogAddItemBinding.dialogEdtSubtitle.text.toString()
                    val txtDetail = dialogAddItemBinding.dialogAddEdtDetail.text.toString()
                    val txtUrl = dialogAddItemBinding.dialogAddEdtUrl.text.toString()
                    val isTrend = dialogAddItemBinding.checkBoxTrend.isChecked
                    val showExplore = dialogAddItemBinding.checkBoxExplore.isChecked
                    val showGroup = dialogAddItemBinding.checkBoxGroups.isChecked
                    val showOthers = dialogAddItemBinding.checkBoxOthers.isChecked

                    val insight = if (isTrend) {
                        val randomNum = (1..500).random()
                        "+$randomNum K"
                    } else {
                        ""
                    }
                    alertDialog.dismiss()
                    val item = ItemPost(txtUrl,txtTitle,txtSubtitle,txtDetail,isTrend,insight,showExplore,showGroup,showOthers)
                    othersCloneList.add(0,item)
                    (requireActivity() as MainActivity).getData().add(0,item)
                    myAdapter.notifyItemInserted(0)
                    binding.recyclerOthers.scrollToPosition(0)

                } else {
                    Toast.makeText(context, "Complete all parts", Toast.LENGTH_SHORT).show()
                }
            }


        }

    }

    override fun onItemClicked(itemPost: ItemPost) {
        val intent = Intent(activity, MainActivity2::class.java)
        intent.putExtra(SEND_DATA_TO_MAIN_ACTIVITY2, itemPost)
        startActivity(intent)
    }

    override fun onItemLongClicked(itemPost: ItemPost) {
        Toast.makeText(context, "${itemPost.txtTitle}", Toast.LENGTH_SHORT).show()

        if ((requireActivity() as MainActivity).isWriter()) {
            val sweetAlertDialog = SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
            sweetAlertDialog.titleText = "Delete item"
            sweetAlertDialog.confirmText = "Delete"
            sweetAlertDialog.cancelText = "Cancel"
            sweetAlertDialog.contentText = "want to delete this item?!"

            sweetAlertDialog.setCancelClickListener {
                sweetAlertDialog.dismiss()
            }

            sweetAlertDialog.setConfirmClickListener {
                (requireActivity() as MainActivity).deleteItem(itemPost)
                myAdapter.notifyItemRemoved(othersCloneList.indexOf(itemPost))
                othersCloneList.remove(itemPost)
                sweetAlertDialog.dismiss()

            }

            sweetAlertDialog.show()
        } else {

        }

    }


}