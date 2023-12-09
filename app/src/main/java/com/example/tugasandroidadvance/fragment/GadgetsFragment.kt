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
import com.example.tugasandroidadvance.databinding.FragmentGadgetsBinding

class GadgetsFragment : Fragment() ,ItemEvents{

    lateinit var binding: FragmentGadgetsBinding
    lateinit var myAdapter: ExploreAdapter
    lateinit var groupsCloneList: ArrayList<ItemPost>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentGadgetsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        groupsCloneList = (requireActivity() as MainActivity).getData().filter { it.showGadgets } as ArrayList<ItemPost>


        val dataGroups = arrayListOf(
            ItemPost(
                "https://static.wikia.nocookie.net/doraemon/images/e/ee/Doko-Demo-Doa.png/revision/latest?cb=20140308163355&path-prefix=en",
                "Anywhere Door",
                "Portal",
                "The history of the Anywhere Door is seen in Doraemon 2013 movie, Doraemon: Nobita's Secret Gadget Museum.\n" +
                        "\n" +
                        "The first ever prototype of the Anywhere Door is gigantic, almost as tall as a three-story house, created by Dr. Hartman. The design was unlike its newer successors, with the door sliding out from the sides of the door. In the movie, Nobita and the others went through it instantly like the current version of Dokodemo Door, but it is highly possible that it has been programmed to warp visitors instantly to the Robots Halls.\n" +
                        "\n" +
                        "The other newer prototypes are significantly smaller, about the size of a mansion's door. Some of them have no doors, which looks like a warp gate instead. Some of the prototypes have a computer next to it, allowing its users to key in their destinations. Most of the designs are quite contemporary- if not just typically modern.",
                false,
                "", false, true, false
            ),
            ItemPost(
                "https://static.wikia.nocookie.net/doraemon/images/e/e8/Bambo.jpeg/revision/latest?cb=20130708031038&path-prefix=en",
                "Take-Copter",
                " Powered Rotor",
                "Take-copter or Bamboo Copter (\"The Hopter\" in the US English dub and manga) is a gadget of 22nd century which is used by humans mostly.\n" +
                        "\n" +
                        "The Take-copter is a small yellow colored gadget consisting of horizontally spinning rooters guided by a thin shaft which connects to a wide base. It can easily fit into a normal pocket present in pants or trousers. Sometimes, it consists of a button at the back or on top.\n" +
                        "\n" +
                        "In 1973 anime, the Take-copter had a wider and conical base and the middle part seemed like an antennae.\n" +
                        "\n" +
                        "In 1979 anime and 2005 anime, it had a semi spherical base and was smaller than the 1973 one.\n" +
                        "\n" +
                        "In Stand by Me Doraemon, it had a brown colored suction cap at the base.\n" +
                        "\n" +
                        "Dorami's Take-copter is generally pink colored.\n" +
                        "\n" +
                        "Mini-Doras' Take-copters look exactly same as Doraemon's but they are very small on the basis of size.",
                false,
                "", false, true, false
            ),
            ItemPost(
                "https://static.wikia.nocookie.net/doraemon/images/f/fe/Images.jpeg/revision/latest?cb=20130708030507&path-prefix=en",
                "Time Machine",
                "Time Machine/Hovercraft",
                "The Time Machine consists of a computer operator and a panel consisting of few handles and switches. It has minimum one seat for the driver to sit. It also consists of an antennae like projection(s) which collects signals.\n" +
                        "\n" +
                        "Doraemon's Time Machine is the most commonly seen and used time machine in the franchise. It consists of a nearly-square-shaped chassis, with various appliances mounting on it, such as controls, antennae, etc. The machine is magnetically powered. It originally has the capacity to hold up to three people at maximum. But since it had broken down once, Doraemon upgraded the gadget, and it is now able to transport up to five people. It is placed in the upper drawer of Nobita's desk in Nobita's room in Nobi's Residence. In the 1973 anime, Doraemon's Time Machine had two seats like a car's interior and two levers. It was fully purple coloured. The antennae didn't exist.",
                false,
                "", false, true, false
            ),
            ItemPost(
                "https://static.wikia.nocookie.net/doraemon/images/a/aa/Copying_Toast2005.png/revision/latest?cb=20140916135317&path-prefix=en",
                "Copying Toast",
                "Food; Bread",
                "To use the Copying Toast, one should press one side of the toast on a book with either text or pictures. The text or picture will then be 'printed' (in the bread's case, 'sticks onto it') on the toast. Eating the toast later will allow the eater to remember whatever content that has been printed on the toast.\n" +
                        "\n" +
                        "The user will forget the content (if they never did memorize it normally) if the toasts are expelled out from their system. Like how Nobita had a stomach ache and had to 'expel' them into the toilet, he forgets everything printed on the toasts.",
                false,
                "", false, true, false
            ),
            ItemPost(
                "https://static.wikia.nocookie.net/doraemon/images/e/e5/Small_Light.jpg/revision/latest?cb=20190630111918&path-prefix=en",
                "Small Light",
                "Flashlight",
                "It is a green flashlight with a yellow-orange bottom. It has a blue top with four spheres on it, and a glass hemisphere that emits the light beam. It also has two buttons, the red one shrinks the target, while the yellow one serves a reverse setting as it enlarges the target back to normal size.",
                false,
                "", false, true, false
            ) ,

        )

        myAdapter = ExploreAdapter(groupsCloneList,this)
        binding.recyclerGroups.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.recyclerGroups.adapter = myAdapter

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
                    groupsCloneList.add(0,item)
                    (requireActivity() as MainActivity).getData().add(0,item)
                    myAdapter.notifyItemInserted(0)
                    binding.recyclerGroups.scrollToPosition(0)

                } else {
                    Toast.makeText(context, "Complete all parts", Toast.LENGTH_SHORT).show()
                }
            }


        }

    }

    override fun onItemClicked(itemPost: ItemPost) {
        val intent = Intent(activity, MainActivity2::class.java)
        intent.putExtra(SEND_DATA_TO_MAIN_ACTIVITY2,itemPost)
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
                myAdapter.notifyItemRemoved(groupsCloneList.indexOf(itemPost))
                groupsCloneList.remove(itemPost)
                sweetAlertDialog.dismiss()

            }

            sweetAlertDialog.show()
        } else {

        }

    }

}