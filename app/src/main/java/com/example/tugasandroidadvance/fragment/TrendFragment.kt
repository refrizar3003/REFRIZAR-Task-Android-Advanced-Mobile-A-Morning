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
import com.example.tugasandroidadvance.adapter.ItemEvents
import com.example.tugasandroidadvance.adapter.TrendAdapter
import com.example.tugasandroidadvance.data.ItemPost
import com.example.tugasandroidadvance.databinding.DialogAddItemBinding
import com.example.tugasandroidadvance.databinding.FragmentTrendBinding

class TrendFragment : Fragment(), ItemEvents {

    lateinit var binding: FragmentTrendBinding
    lateinit var myAdapter: TrendAdapter
    lateinit var trendCloneList: ArrayList<ItemPost>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTrendBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        trendCloneList = (requireActivity() as MainActivity).getData().filter { it.isTrend } as ArrayList<ItemPost>


        val dataTrend = arrayListOf(
            ItemPost(
                "https://static.wikia.nocookie.net/doraemon/images/8/8d/Doraemon_%282017_Remake%29.png/revision/latest/scale-to-width-down/350?cb=20230908064228&path-prefix=en",
                "Doraemon",
                "Robot Cat, Main Character",
                "Doraemon is a blue cat robot corresponding (tints of pink-orange in earlier comic chapters and media) from the 22nd century. Despite being based on a cat, hence his title as the \"Gadget Cat from the Future\" in the Americanized Doraemon dub, Doraemon resembles a racoon dog (referred to as a seal in the American dub), albeit it being a running joke. He is blue in color while his face and front middle portion of the body being white in color. He has got circular palms and feet. He has 6 whiskers like cats. Although being made up of metal, he can get squeezed and can be stretched. He has big eyes, a red circular nose and a big mouth consisting of huge teeth. He had ears which were eaten by a mouse (a robot mouse that misunderstood an order in the OVA), hence why he more resembles a racoon dog. He has a red tail which acts like a power lever.",
                true,
                "+500 K",
                false, false, false
            ),
            ItemPost(
                "https://static.wikia.nocookie.net/doraemon/images/4/4c/Nobita_567c.jpg/revision/latest?cb=20190730015053&path-prefix=en",
                "Nobita Nobi",
                "Main Character",
                "Nobita is the hero at best and the villain at worst. At the beginning of the series, Nobita is a rather lazy person who has a cycle of constantly napping after school, keeping him up late when he wakes up late for school. This cycle of laziness occurs almost every day, keeping him up late at night and wake up late the next morning, hindering him academically. Nobita is very dependent on Doraemon and begs for multiple things, much to his disapproval. Many things that Nobita wishes for include; vengeance on his bullies, a better product than what Suneo brags about, and privileges.\n" +
                        "\n" +
                        "While his laziness is an issue, he slacks around in school. He regularly arrives late, is tardy with homework, and gets 0% on both exams and tests. The Classroom Teacher usually punishes him for this with after-school detentions or making him stand by the classroom door for long periods of time. His refusal, procrastination and dislike of studying while at home puts him back from excelling even further. His mother is constantly disappointed and angry with his lackluster performance. He later tries to hide his poor scores, which has proven unsuccessful. He also doesn't like to study, which only further hinders his performance in school. Nobita is not very athletic either, much to Gian's frustration. He is terrible at baseball and many other sports, often letting down Gian's baseball team. He doesn't have very good endurance as he run, walk or swim for a short period of time then easily get tired and exhausted very quickly, much to his friends' frustration.",
                true,
                "+400 K",
                false, false, false
            ),
            ItemPost(
                "https://static.wikia.nocookie.net/doraemon/images/7/71/C0E297DC-08AE-43E6-841D-41E95B2FC8D0.jpeg/revision/latest?cb=20181218213552&path-prefix=en",
                "Shizuka Minamoto",
                "Main Character",
                "Shizuka is a smart and kind neighbourhood girl. She is, unlike Nobita, a quick-witted and very studious child. Shizuka loves to bathe and does it several times a day passionately. Unlike Nobita, Suneo, and Gian, she is not a fan of video games for the most part.\n" +
                        "\n" +
                        "She cares for weaker people, abused animals and neglected dolls. She wishes to be a nurse or an air-hostess when she grows up. Both jobs reflect her kind nature. Shizuka loves her dolls a lot, to the extent that she loves them more than her own friends. She once freed a little bird from a bundle of strings it got caught in. She also cares deeply for the Grandfather Tree. When she was unable to save the Grandfather Tree, she was devastated but later felt relieved when she saw a little sprout from the Grandfather Tree stump. In one episode, Doraemon, Nobita, and Shizuka put her dolls in Nobita's race cars and started racing. Nobita's car crashed and the doll fell out, and she began to cry and get angry at him. But when she sees Nobita doing the right thing or a good thing for others, it would be enough to make her genuinely forgive Nobita.",
                true,
                "+180 K",
                false, false, false
            ),
            ItemPost(
                "https://static.wikia.nocookie.net/doraemon/images/4/45/Jaian_2005_ID.png/revision/latest?cb=20181215062535&path-prefix=en",
                "Takeshi \"Gian\" Gouda",
                " Main Character",
                "He is recognized by his large build (might partly be contributed by obesity) as well as his mean and aggressive behavior. He \"rules\" the neighborhood with force, often at the physical expense of other children, especially Nobita, who often resorts to asking Doraemon for gadgets to get even on him. He appears to be just as dependent on Nobita as Nobita is on Doraemon as he constantly tells him what to do despite Nobita's protests. In addition, he has a tendency to steal or rob others, usually Suneo, who offers to be Gian's sidekick on most occasions.",
                true,
                "+50 K",
                false, false, false
            ),
            ItemPost(
                "https://static.wikia.nocookie.net/doraemon/images/7/77/Suneo_2005_anime_ID.png/revision/latest?cb=20191226041540&path-prefix=en",
                "Suneo Honekawa",
                "Main Character",
                "He gets around ¥5000 (US\$40, £25.65) in monthly pocket money and buys cool toys and comic books, but he never lets Nobita touch his comics and cool toys, which provokes his anger and jealousy. He usually hangs out with Gian to think he is the coolest kid in the world like Gian and often bullies, irritates and/or beats up Nobita with Gian. Sometimes, his encomiastic tendencies come into play against Gian's threats. He is also a member of the Giants baseball team and while he isn't particularly proficient, he still somewhat surpasses the weaker Nobita.",
                true,
                "+50 K",
                false, false, false
            ),
        )
        myAdapter = TrendAdapter(trendCloneList, this)
        binding.recyclerTrend.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.recyclerTrend.adapter = myAdapter

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
                    trendCloneList.add(0,item)
                    (requireActivity() as MainActivity).getData().add(0,item)
                    myAdapter.notifyItemInserted(0)
                    binding.recyclerTrend.scrollToPosition(0)

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

        if ((requireActivity() as MainActivity).isWriter() ) {
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
                myAdapter.notifyItemRemoved(trendCloneList.indexOf(itemPost))
                trendCloneList.remove(itemPost)
                sweetAlertDialog.dismiss()

            }

            sweetAlertDialog.show()
        } else {

        }

    }

}