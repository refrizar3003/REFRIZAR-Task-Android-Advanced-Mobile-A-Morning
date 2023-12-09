package com.example.tugasandroidadvance.activity

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.tugasandroidadvance.R
import com.example.tugasandroidadvance.data.ItemPost
import com.example.tugasandroidadvance.data.Person
import com.example.tugasandroidadvance.databinding.ActivityMainBinding
import com.example.tugasandroidadvance.databinding.DialogSignUpBinding
import com.example.tugasandroidadvance.fragment.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    // all local data we have
    val allData = arrayListOf(
        ItemPost(
            "https://static.wikia.nocookie.net/doraemon/images/8/8d/Doraemon_%282017_Remake%29.png/revision/latest/scale-to-width-down/350?cb=20230908064228&path-prefix=en",
            "Doraemon",
            "Robot Cat, Main Character",
            "Doraemon is a blue cat robot corresponding (tints of pink-orange in earlier comic chapters and media) from the 22nd century. Despite being based on a cat, hence his title as the \"Gadget Cat from the Future\" in the Americanized Doraemon dub, Doraemon resembles a racoon dog (referred to as a seal in the American dub), albeit it being a running joke. He is blue in color while his face and front middle portion of the body being white in color. He has got circular palms and feet. He has 6 whiskers like cats. Although being made up of metal, he can get squeezed and can be stretched. He has big eyes, a red circular nose and a big mouth consisting of huge teeth. He had ears which were eaten by a mouse (a robot mouse that misunderstood an order in the OVA), hence why he more resembles a racoon dog. He has a red tail which acts like a power lever.",
            false,
            "",
            true, false, false
        ),
        ItemPost(
            "https://static.wikia.nocookie.net/doraemon/images/4/4c/Nobita_567c.jpg/revision/latest?cb=20190730015053&path-prefix=en",
            "Nobita Nobi",
            "Main Character",
            "Nobita is the hero at best and the villain at worst. At the beginning of the series, Nobita is a rather lazy person who has a cycle of constantly napping after school, keeping him up late when he wakes up late for school. This cycle of laziness occurs almost every day, keeping him up late at night and wake up late the next morning, hindering him academically. Nobita is very dependent on Doraemon and begs for multiple things, much to his disapproval. Many things that Nobita wishes for include; vengeance on his bullies, a better product than what Suneo brags about, and privileges.\n" +
                    "\n" +
                    "While his laziness is an issue, he slacks around in school. He regularly arrives late, is tardy with homework, and gets 0% on both exams and tests. The Classroom Teacher usually punishes him for this with after-school detentions or making him stand by the classroom door for long periods of time. His refusal, procrastination and dislike of studying while at home puts him back from excelling even further. His mother is constantly disappointed and angry with his lackluster performance. He later tries to hide his poor scores, which has proven unsuccessful. He also doesn't like to study, which only further hinders his performance in school. Nobita is not very athletic either, much to Gian's frustration. He is terrible at baseball and many other sports, often letting down Gian's baseball team. He doesn't have very good endurance as he run, walk or swim for a short period of time then easily get tired and exhausted very quickly, much to his friends' frustration.",
            false,
            "",
            true, false, false
        ),
        ItemPost(
            "https://static.wikia.nocookie.net/doraemon/images/7/71/C0E297DC-08AE-43E6-841D-41E95B2FC8D0.jpeg/revision/latest?cb=20181218213552&path-prefix=en",
            "Shizuka Minamoto",
            "Main Character",
            "Shizuka is a smart and kind neighbourhood girl. She is, unlike Nobita, a quick-witted and very studious child. Shizuka loves to bathe and does it several times a day passionately. Unlike Nobita, Suneo, and Gian, she is not a fan of video games for the most part.\n" +
                    "\n" +
                    "She cares for weaker people, abused animals and neglected dolls. She wishes to be a nurse or an air-hostess when she grows up. Both jobs reflect her kind nature. Shizuka loves her dolls a lot, to the extent that she loves them more than her own friends. She once freed a little bird from a bundle of strings it got caught in. She also cares deeply for the Grandfather Tree. When she was unable to save the Grandfather Tree, she was devastated but later felt relieved when she saw a little sprout from the Grandfather Tree stump. In one episode, Doraemon, Nobita, and Shizuka put her dolls in Nobita's race cars and started racing. Nobita's car crashed and the doll fell out, and she began to cry and get angry at him. But when she sees Nobita doing the right thing or a good thing for others, it would be enough to make her genuinely forgive Nobita.",
            false,
            "",
            true, false, false
        ),
        ItemPost(
            "https://static.wikia.nocookie.net/doraemon/images/4/45/Jaian_2005_ID.png/revision/latest?cb=20181215062535&path-prefix=en",
            "Takeshi \"Gian\" Gouda",
            " Main Character",
            "He is recognized by his large build (might partly be contributed by obesity) as well as his mean and aggressive behavior. He \"rules\" the neighborhood with force, often at the physical expense of other children, especially Nobita, who often resorts to asking Doraemon for gadgets to get even on him. He appears to be just as dependent on Nobita as Nobita is on Doraemon as he constantly tells him what to do despite Nobita's protests. In addition, he has a tendency to steal or rob others, usually Suneo, who offers to be Gian's sidekick on most occasions.",
            false,
            "",
            true, false, false
        ),
        ItemPost(
            "https://static.wikia.nocookie.net/doraemon/images/7/77/Suneo_2005_anime_ID.png/revision/latest?cb=20191226041540&path-prefix=en",
            "Suneo Honekawa",
            "Main Character",
            "He gets around ¥5000 (US\$40, £25.65) in monthly pocket money and buys cool toys and comic books, but he never lets Nobita touch his comics and cool toys, which provokes his anger and jealousy. He usually hangs out with Gian to think he is the coolest kid in the world like Gian and often bullies, irritates and/or beats up Nobita with Gian. Sometimes, his encomiastic tendencies come into play against Gian's threats. He is also a member of the Giants baseball team and while he isn't particularly proficient, he still somewhat surpasses the weaker Nobita.",
            false,
            "",
            true, false, false
        ),
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
        ),

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
        ),
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

    // if a writer joins the app we will re assign person values
    val person = Person("", "", "", "")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // used to check bottom navigation items
        var currentBottomNavigation = R.id.menu_explore


        setSupportActionBar(binding.toolbarMain)
        val actionBarDrawerToggle =
            ActionBarDrawerToggle(
                this, binding.drawerLayoutMain, binding.toolbarMain,
                R.string.openDrawer, R.string.closeDrawer
            )
        actionBarDrawerToggle.syncState()
        binding.drawerLayoutMain.addDrawerListener(actionBarDrawerToggle)

        binding.navigationViewMain.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.menu_writer -> {

                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                    if (person.name.isNotEmpty()) {
                        val saDialog = SweetAlertDialog(this, SweetAlertDialog.NORMAL_TYPE)
                        saDialog.titleText = "Information!"
                        saDialog.confirmText = "Confirm"
                        saDialog.contentText = "You are already a writter"
                        saDialog.show()
                    } else {

                        val sweetAlertDialog = SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                        sweetAlertDialog.titleText = "Alert!"
                        sweetAlertDialog.confirmText = "Confirm"
                        sweetAlertDialog.cancelText = "Cancel"
                        sweetAlertDialog.contentText = "Wanna be a writer?"

                        sweetAlertDialog.setCancelClickListener {
                            sweetAlertDialog.dismiss()
                        }

                        sweetAlertDialog.setConfirmClickListener {
                            sweetAlertDialog.dismiss()
                            val alertDialog = AlertDialog.Builder(this).create()
                            val dialogBinding = DialogSignUpBinding.inflate(layoutInflater)
                            alertDialog.setView(dialogBinding.root)
                            alertDialog.setCancelable(true)
                            alertDialog.show()

                            dialogBinding.btnSignUp.setOnClickListener {

                                if (dialogBinding.dialogEdtName.length() > 0 && dialogBinding.dialogEdtGmail.length() > 0 && dialogBinding.dialogEdtId.length() > 0) {
                                    person.name = dialogBinding.dialogEdtName.text.toString()
                                    person.gmail = dialogBinding.dialogEdtGmail.text.toString()
                                    person.id = dialogBinding.dialogEdtId.text.toString()
                                    person.job = "Writer"
                                    replaceFragment(ProfileFragment(person))
                                    alertDialog.dismiss()
                                    checkCurrentBNItem(R.id.menu_profile, true)

                                } else {
                                    Toast.makeText(this, "Complete all parts", Toast.LENGTH_SHORT)
                                        .show()
                                }

                            }
                        }

                        sweetAlertDialog.show()

                    }
                }

                R.id.menu_groups -> {

                    menuItemsListener(1, GadgetsFragment())

                }
                R.id.menu_other -> {

                    menuItemsListener(2, SeriesFragment())

                }


                ////////////////////////////////////////////////////////////

                R.id.menu_open_wikipedia -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                    openWebsite("https://breakingbad.fandom.com/wiki/Breaking_Bad_Wiki")

                }

            }
            true
        }

        firstRun()

        binding.bottomNavigationMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_explore -> {
                    currentBottomNavigation = R.id.menu_explore
                    replaceFragment(ExploreFragment())
                }
                R.id.menu_trend -> {
                    currentBottomNavigation = R.id.menu_trend
                    replaceFragment(TrendFragment())
                }
                R.id.menu_profile -> {

                    if (person.name.isNotEmpty()) {
                        replaceFragment(ProfileFragment(person))
                    } else {

                        val sweetAlertDialog = SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        sweetAlertDialog.titleText = "You are not a writer!"
                        sweetAlertDialog.confirmText = "SignUp"
                        sweetAlertDialog.cancelText = "Cancel"
                        sweetAlertDialog.contentText = "Wanna be a writer?"

                        sweetAlertDialog.setCancelClickListener {
                            sweetAlertDialog.dismiss()
                            checkCurrentBNItem(currentBottomNavigation, true)
                        }

                        sweetAlertDialog.setConfirmClickListener {
                            sweetAlertDialog.dismiss()
                            val alertDialog = AlertDialog.Builder(this).create()
                            val dialogBinding = DialogSignUpBinding.inflate(layoutInflater)
                            alertDialog.setView(dialogBinding.root)
                            alertDialog.setCancelable(true)
                            alertDialog.show()
                            checkCurrentBNItem(currentBottomNavigation, true)


                            dialogBinding.btnSignUp.setOnClickListener {
                                currentBottomNavigation = R.id.menu_profile
                                checkCurrentBNItem(currentBottomNavigation, true)


                                if (dialogBinding.dialogEdtName.length() > 0 && dialogBinding.dialogEdtGmail.length() > 0 && dialogBinding.dialogEdtId.length() > 0) {
                                    person.name = dialogBinding.dialogEdtName.text.toString()
                                    person.gmail = dialogBinding.dialogEdtGmail.text.toString()
                                    person.id = dialogBinding.dialogEdtId.text.toString()
                                    person.job = "Writer"
                                    replaceFragment(ProfileFragment(person))
                                    alertDialog.dismiss()

                                } else {
                                    Toast.makeText(this, "Complete all parts", Toast.LENGTH_SHORT)
                                        .show()
                                }


                            }
                        }

                        sweetAlertDialog.show()
                    }

                }
            }

            binding.navigationViewMain.menu.getItem(1).isChecked = false
            binding.navigationViewMain.menu.getItem(2).isChecked = false

            true
        }
        binding.bottomNavigationMain.setOnItemReselectedListener {
            // do nothing
        }

    }

    private fun openWebsite(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main, fragment)
        transaction.commit()
    }

    private fun firstRun() {
        replaceFragment(ExploreFragment())
    }


    override fun onBackPressed() {
        super.onBackPressed()
        // check menu item off
        binding.navigationViewMain.menu.getItem(1).isChecked = false
        binding.navigationViewMain.menu.getItem(2).isChecked = false
    }




    fun checkCurrentBNItem(currentBottomNavigation: Int, isChecked: Boolean) {
        binding.bottomNavigationMain.menu.findItem(currentBottomNavigation).isChecked = isChecked
    }

    private fun menuItemsListener(menuItem: Int, fragment: Fragment) {

        if (menuItem == 1) {
            binding.navigationViewMain.menu.getItem(2).isChecked = false
        } else if (menuItem == 2) {
            binding.navigationViewMain.menu.getItem(1).isChecked = false
        }

        binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frame_main, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

        // check menu item
        binding.navigationViewMain.menu.getItem(menuItem).isChecked = true

        // uncheck bottom navigation

        checkCurrentBNItem(R.id.menu_explore, false)
        checkCurrentBNItem(R.id.menu_trend, false)
        checkCurrentBNItem(R.id.menu_profile, false)

        binding.bottomNavigationMain.menu.setGroupCheckable(0, true, false)
        for (i in 0 until binding.bottomNavigationMain.menu.size()) {
            binding.bottomNavigationMain.menu.getItem(i).isChecked = false
        }
        binding.bottomNavigationMain.menu.setGroupCheckable(0, true, true)


        // close drawer
        binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

    }

    fun getData(): ArrayList<ItemPost> {
        return allData
    }

    fun deleteItem(itemPost: ItemPost) {
        allData.remove(itemPost)
    }

    fun isWriter() : Boolean{
    return person.name != ""
    }



}