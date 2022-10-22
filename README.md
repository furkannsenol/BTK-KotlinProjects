gorseldeki nesnelere ulasmak icin build.gradle module gir
buildFeatures {
        viewBinding true
    }
	
	private lateinit var binding: ActivityMainBinding 

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)
}

plugins
	id  'kotlin-android'
    id  'kotlin-android-extensions'
--------------------------------------------------------------------------------------------------------
variables & Constants(değişkenler ve sabitler)
var: değişken
val: sabit
Defining: tanımlamak
Initialize: atamak
--------------------------------------------------------------------------------------------------------
var sayi : int = 10 (sayi degiskenin tipini int olarak atıyorsun)
		 : long
		 
double default olarak geliyor. 
	var sayi= 3.14
	var sayi : double = 3.14  ikiside aynı 
	
var sayi : float = 3.14f //float tanımlama 
--------------------------------------------------------------------------------------------------------
Dizi için Array fonksiyonunu kullanıyorsun
	arrayListOf()
		-deger eklemek icin .add parametresi kullanılır
	arrayOf() : karısık veri tiplerini bir arada tutar
		-deger eklemek icin set kullanılır

val dizi içindeki eleman listelerine karısmıyor, sonradan veri ekleme cıkarma işlemlerini gerçekleştirebilir


	
Dizi[0] ile Dizi.get(0) aynı şey 

Dizi.set(3,"Mahmut") // Diziye eleman ekleme arrayOf ile
Dizi.add("Mahmut) // Diziye eleman ekleme arrayListOf ile 
val dizi = doubleArrayOf(1.0,2.1)

val stringdizisi = arrayListOf<String>()
val anydizi = arrayListOf<Any>()
--------------------------------------------------------------------------------------------------------
Set yapısı
tekrarsız bir şekilde verileri ekler

val benimset= setOf(1,2,2,3,3,4)
println(benimset.size) // çıktı 4 olur uzunluk size ile alınıyor
For Each
benimset.forech{
it:int					// benimset dizisindeki elemanları tekrarsız sırayla it degiskenine atıyor
}

HashSet setOf ile aynı mantık

println("ilk eleman: ${dizi[0]}")
--------------------------------------------------------------------------------------------------------
map ise anahtar değer eşleşmesi
val yemekkalori = hashMapOf<String,Int>()

yemekkalori.put("Furkan",23)
veya 
val yemekkalori = hashMapOf<String,Int>("Atıl" to 40, "Ahmet" to 21)

val yemekkalori2 = HashMap<String,String>()
--------------------------------------------------------------------------------------------------------
*case break a benziyor if else yapısının biraz daha özelleştirilmiş hali
when(harfnotu){
	0->notstringi="GeçersizNot"
	1->notstringi="Zayıf"
	else -> notstringi="geçersiz not"
}
--------------------------------------------------------------------------------------------------------
for(deneme in baskabirDizi)	dizideki degerleri deneme adında yeni bir degiskene atıyor
	println(deneme)			
					
baskabirDizi.indices // dizideki elemanların indisini veriyor.   

for(i in dizi.indices)		|
	val qz = dizi[i]	|
	println(qz)		|
				  >//ikiside aynı şeyi yapıo
dizi.forEach{println(it)}	|
--------------------------------------------------------------------------------------------------------
Fonksiyon
onCreate()
textAd.text= deneme(10,20).toString()

fun deneme(a:Int,b: Int):Int { //fonksiyonun tipini belirledik
        return a*b
    }

//onClick fonksiyonu
fun hop(view: View) {}
--------------------------------------------------------------------------------------------------------
constructor: sınıfdan herhangi bir obje olusturuldugu zaman cagıralacak metot

var age=0 (thisde ki age)
constructor(age: Int){
	this.age=age
	}
	
bunu yapmaktansa tek satırda halledebilion
class Simpson(var age:Int, var name:String){
}
--------------------------------------------------------------------------------------------------------
Erişebilirlik Seviyeleri
	private
	protected kalıtım
	internal farklı modulden ulasılamıo sadece
	public
--------------------------------------------------------------------------------------------------------
Nullable (?) && Non-null (!!)

var myString : String? = null
--------------------------------------------------------------------------------------------------------
Güvenli Kodlar
1.Null safety ( null guvenligi)
if(myAge !=null)
2. safe call
myage?.compareTo(2) //degiskene ? atmak
3. elvis
result=myAge?.compareTo(2) ?: -100 //myAge?.compareTo(2) eğer boş olursa değerini -100 yaz demek
--------------------------------------------------------------------------------------------------------
xml deki objeleri cagırmanmın 3 yolu var
1. findbyId
2.     id  'kotlin-android-extensions'
		import kotlinx.android.synthetic.main.activity_main.*
3. Binding



--------------------------------------------------------------------------------------------------------
										2. Bölüm
--------------------------------------------------------------------------------------------------------	
verileri hafıza da tutma(StoringData)
	sharedPreferences(paylaşılan tercihler)
	val sharedPreferences = this.getSharedPreferences("packapge name",MODE_PRIVATE)
	
	ageFromPreferences = sharedPreferences.getInt("age", -1)
	age_text.text = "Your Age: $ageFromPreferences"
	sharedPreferences.edit().putInt("age", myAge).apply()
	sharedPreferences.edit().remove("age").apply()
--------------------------------------------------------------------------------------------------------	
Intent 
	sayfalar arası geçiş 
	
	val next_page = Intent(applicationContext,NextActivity::class.java)
        startActivity(next_page)
--------------------------------------------------------------------------------------------------------		
context projenin herşeyle haberleşmesi
--------------------------------------------------------------------------------------------------------
Sayfalar arası veri aktarımı

//getIntent
        val intent = intent
        val name= intent.getStringExtra("name")
		
//setIntent
 var name = name_input.text.toString()
        val intent = Intent(applicationContext, NextActivity::class.java)
        intent.putExtra("name", name)
        startActivity(intent)
--------------------------------------------------------------------------------------------------------
Activity Yaşam Döngüsü
onCreate
onStart
onResume
onPause
onStop
onDestroy	
--------------------------------------------------------------------------------------------------------
Toast mesaj
	Toast.makeText(applicationContext,"Merhaba",Toast.LENGTH_LONG).show()
--------------------------------------------------------------------------------------------------------
Alert Dialog
  val alert = AlertDialog.Builder(this)
        alert.setTitle("Save")
            .setMessage("Are You Sure?")
            .setPositiveButton("Yes") {dialog , it ->
                Toast.makeText(applicationContext,"Saved",Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("No"){dialog, it ->
                Toast.makeText(applicationContext,"Not Saved",Toast.LENGTH_LONG).show()
            }
            .show()
--------------------------------------------------------------------------------------------------------
Context Yapısı
	Activity Context -> this (this bir üst kod blogunu ifade eder. İlgili activity de işlem yapıldıgı zaman kullanılır. 
						Bazı durumlarda iç içe kod bloklarında this kullanıldıgında activity i görmeyebilir o zaman
			this@MainActivity gibi kullanılır
	App Context -> applicationContext ( uygulamayı ilgilendiren context lerde kullanılır)
--------------------------------------------------------------------------------------------------------
Sayaç(CountDownTimer)
cannot create an instance of an abstract(soyut) class: soyut bir sınıf istance oluşturamıyor
abstract gibi obje odaklardan sınıf oluşturulamıyor
Inheritance kalıtım alma (sınıfın özelliklerini alma)

object seklinde tanımlayıp anonymouse(isimsiz bir sınıf) oluşturuyoruz
onFinish() bitince ne olmasını istiosan onu yaz
onTick() her seferinde yapılacak işlem (saniyeyi azaltma gibi)


object : CountDownTimer(10000,1000) {
            override fun onTick(millisUntilFinished: Long) {
                timer_Text.text="Left: ${millisUntilFinished/1000}"
            }

            override fun onFinish() {
                timer_Text.text="Left: 0"
            }
--------------------------------------------------------------------------------------------------------
Runnable and Handler(sayaç)
--------------------------------------------------------------------------------------------------------
 //Log.w("firebase_authentication", "createUserWithEmail:failure", task.exception)
--------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------
OOP(OBJECT ORIENTED PROGRAMMING)(OBJE ODAKLI PROGRAMLAMA) = (NESNERYE YÖNELİMLİ PROGRAMLAMA (NYP))

Counstructor
class User {

    var name: String? = null
    var age: Int? = null

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }
}

init{
	println("asd")
}

init metodu sınıftan bir nesne üretildiğinde çalışır ve genelde ilgili nesne üretildiğinde yapılmasını istediğimiz işlemleri init metodu içerisine yazarız.
--------------------------------------------------------------------------------------------------------
Encapsulation: Kapsülleme kısaca oluşturduğumuz nesneye dışarıdan müdahaleyi sınırlamak için kullanılır diyebiliriz.
 Sınıfa tanımladığımız özelliğin başına private ön ekini kullanırız ve bu sayede dışarıdan bu sınıfın private olan özelliklerine erişilemez.

class Musician(name: String, instrument: String, age: Int) {

    //encapsulation
    var name: String? = name
        private set
        get

    private var instrument: String? = instrument

    var age: Int? = age
        get
        private set
		
	fun returnBandName(password: String): String {
        if (password == "Furkan")
            return bandName
        else
            return "ZOOOORT"
    }
}

//Encapsulation
        var musician=Musician("Furkan","Saksofon",25)
        //musician.instrument (ulaşılamaz cunku get ve set private)
        //musician.age=24 (set private oldugundan deger atılamıyor)
        Log.w("musician.age","${musician.age}")
		println(musician.returnBandName("Furkan"))
        println(musician.returnBandName("Koray"))
--------------------------------------------------------------------------------------------------------
Inheritance (Miras Almak)
Bir sınıf oluşturduğumuzda başka bir sınıfta bu sınıfın özelliklerini kendisine miras olarak alır ve kendisine ait tanımlaması gereken özellikleri varsa onları
tanımlayarak yoluna devam eder.

Kotlin’de bir sınıfı inheritance işlemine açık yapmak istersek sınıfı tanımlarken başında open ön ekini kullanmamız gerekmektedir.
ve constract hatası verir

Miras almak istediğimiz sınıfı ‘:’ ile miras alacağımız sınıfın yanına yazmamız gerekmektedir.

class SuperMusician(name: String, instrument: String, age: Int) : Musician(name, instrument, age) {
    //Inheritance
    fun sign() {
        println("nothing else matters")
    }
	
	 //Inheritance
        var supermusician = SuperMusician("Else","zurna",22)
        println(supermusician.sign())
        println(supermusician.name)
--------------------------------------------------------------------------------------------------------
Polymorphism (Çok Biçimlilik)
Kısaca Polymorphism, aynı ismi kullanarak farklı işlemler yapabilmektir. Polymorphism kendi içinde 2'ye ayrılmaktadır. Aynı sınıf içerisinde aynı isimle farklı işlemler yapmaya static polymorphism denir. Farklı sınıflar içerisinden aynı isimle farklı işlemler yapmaya ise dynamic polymorphism denir.

static ve dinamik olarak ikiye ayrılır

open class Mathematics {
    //static polymorphism
    fun sum(): Int {
        return 0
    }

    fun sum(x: Int, y: Int): Int {
        return x + y
    }

    fun sum(x: Int, y: Int, z: Int): Int {
        return x + y + z
    }

    //dynamic
    open fun deneme() {
        println("dynamic")
    }
	
	
	--
	class Mat2 :Mathematics() {
    //test fonksiyonu nmathematics sınıfına gidip deneme fonksiyonunu cagırır
	//super kelimesi this gibi dusunebilirsin ama bu ozellik kalıtım aldıgı sınıfı referans alıyor ve mathematics sınıfında ki deneme fonksiyonunu çalıştırıyor
    fun test(){
        super.deneme()
    }
    //dynamic polymorphism
    //override ile üstüne yazıyor
    override fun deneme(){
        println("deneme")
    }
}

-- 
//polymorphism
        //static polymorphism
        val mathematics=Mathematics()
        println(mathematics.sum())
        println(mathematics.sum(2,5))
        println(mathematics.sum(2,3,5))

        //dynamic polymorphism
        mathematics.deneme()
        val mat2 = Mat2()
        mat2.deneme()
        mat2.test()
--------------------------------------------------------------------------------------------------------
Abstract Class (Soyut Sınıf)
Ortak özelliklere sahip sınıfları tanımlamak için kullanılan sınıflara Abstract Class denmektedir. Abstract Class’lardan nesneler oluşturulamamaktadır. Abstract sınıfları tanımlarken başlarına ‘abstract’ ön eki yazılmalıdır.

kalıtım alınır
abstract class People {
    fun information(){
        println("information for abstract")
    }
	
	val people= new People() //obje oluşturulamaz
--------------------------------------------------------------------------------------------------------
Interface(2 sınıfdan kalıtım yapma)
class Piano:HouseDecor,Instrument {
    //interface icin class

    var brand:String? = null
    var digital:Boolean? = null

    override var roomName: String
        get() = "Kitchen"
        set(value) {}

   // override fun info() {
     //   println("Instrument info")
    //}
}



interface Instrument {
    fun info(){
      println("Instrument info")
    }

   // fun info()
}

interface HouseDecor {
    //roomname değerini kalıtım yapılacak sınıfda ata
    var roomName:String
}
--------------------------------------------------------------------------------------------------------
LAMBDA GÖSTERİMİ
-> dan önce tanımlama , dan sonra ise yapılacak işlem

  fun lambda(a: String) {
            println(a)
        }
        lambda("fun")

        val lambda2 = { a: String -> println(a) }
        lambda2("LAMBDA DENEME 1")

        val lambda3 = {a:Int,b:Int -> a*b}
        println(lambda3(5,4))             //lambda3 üzreine gelince bir alttaki kod satırı gibi d

		//2. gösterim
        val lambda4 : (Int,Int) -> Int = {a,b -> a*b}
        println(lambda4(5,4))
		
İleri seviye lambda(asynchronous )
asenkron yani eş zamanlı calısmayan gösterim,

1. gösterim 
fun dowloandMusicians(url: String, completion: () -> Unit) {
            completion()
        }

        dowloandMusicians("metalica.com", {
            println("is ready")
        })
		
bir başka gösterim

  fun dowloandMusicians(url: String, completion: (Musician) -> Unit) {
            val music= Musician("name","inst",35)
            completion(music)
        }

        dowloandMusicians("metalica.com", {musician -> //musician -> koymazsan sabit deger it dir it.name diye de cagırabilirsin
            println(musician.name)
        })
    }
--------------------------------------------------------------------------------------------------------
mapping yapısı değiştirmek oluyor
.map 
bir veriyi başka bir veriye benzetme yada değiştirme

     val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, landmarkArray.map { landmark -> landmark.name })

--------------------------------------------------------------------------------------------------------

android in tanımlı hazır listview xml dosyasına ulasmask icin 
 android.R.layout.simple_list_item_1
--------------------------------------------------------------------------------------------------------
 //putextra da sınıf kullanılmaya calıstıgından landmark sınıfını serilazieble etmek gerekiyor
 
class Landmark(val name: String, val country: String, val image: Int) : Serializable {
}
--------------------------------------------------------------------------------------------------------
casting
as diyip sgonderilen obje sınıfını tanmımlar
val selectedLandmark=intent.getSerializableExtra("landmark")  as Landmark
bunu yapmadıgın takdirde selectedlandmark nokta diyip sınıfa ait bilgileri çekemezsin
--------------------------------------------------------------------------------------------------------
listview ile detay sayfasına veri gönderme
homepage
landmarkArray = arrayListOf<Landmark>(
            Landmark("Colosseum", "Italy", R.drawable.colosseum),
            Landmark("Pisa", "Italy", R.drawable.pisa),
            Landmark("Eiffel", "Italy", R.drawable.eiffel),
            Landmark("London Bridge", "Italy", R.drawable.londonbridge)
        )
		
		 val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, landmarkArray.map { landmark -> landmark.name })
        binding.landMarkListView.adapter = adapter

        binding.landMarkListView.onItemClickListener= AdapterView.OnItemClickListener { parent, view, position, id ->

            val intent = Intent(this@MainActivity,DetailActivity::class.java)
            //putextra da sınıf kullanılmaya calıstıgından landmark sınıfını serilazieble etmek gerekiyor
            intent.putExtra("landmark", landmarkArray.get(position))
            startActivity(intent)
        }
		
detay sayfası
   val intent = intent
        //casting
        val selectedLandmark=intent.getSerializableExtra("landmark")  as Landmark
        binding.detailText.text= selectedLandmark.name
        binding.detailImageView.setImageResource(selectedLandmark.image)
--------------------------------------------------------------------------------------------------------

Adapter veri ile view arasındaki baglantıyı gerçekleştirir.
adaptör bir vw ye ihtiyaç duyar(görünüm tutucu) 
inflater : xml ile kodu baglama

--------------------------------------------------------------------------------------------------------
Singleton Class
başka bir actvityde olusturudugn nesneyi baska activityde tanımlamak icin bu sınıfını kullanıosun

class SingletonClass {
    companion object SelectedHero{
         var heroImage : Bitmap? = null
    }
}
--------------------------------------------------------------------------------------------------------

class RecyclerAdapter(val superHeroNameList: ArrayList<String>, val superHeroPictureList: ArrayList<Int>): RecyclerView.Adapter<RecyclerAdapter.SuperHeroVH>() {
    class SuperHeroVH(itemView : View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroVH {
        //inflater xml ile kod arasındaki yapı
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return SuperHeroVH(itemView)
    }

    override fun onBindViewHolder(holder: SuperHeroVH, position: Int) {
        //recyclerviewda ki itemlere ulaşma
        //apply plugin: 'kotlin-android-extensions' rowname idsine ulaşmak için eklemek gerekiyor
        holder.itemView.recyclerRowName.text=superHeroNameList.get(position)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailActivity::class.java)
            intent.putExtra("superHeroNameInfo",superHeroNameList.get(position))
            intent.putExtra("superHeroPicInfo",superHeroPictureList.get(position))
            /*val singletonClass = SingletonClass.SelectedHero
            singletonClass.heroImage=superHeroPictureList.get(position)*/

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        //Recycler view içerisinde kaç eleman olacak
        return superHeroNameList.size
    }
}
--------------------------------------------------------------------------------------------------------
 //RecyclerView in nasıl gorunecegi ayari
        val layoutManager =LinearLayoutManager(this)
        recyclerView_MainPage.layoutManager=layoutManager

        val adapter = RecyclerAdapter(superHeroNames,superHeroPictures)
        recyclerView_MainPage.adapter=adapter
		
--------------------------------------------------------------------------------------------------------
Fragment
sayfa geçişleri 3 hamlede oluyor.
fragmentmanager ve transsaction nesnelri alıyor

val fragmenManager=supportFragmentManager
        val fragmentTransaction=fragmenManager.beginTransaction()//işi başlat diyorsun

        val firstFragment= FirstFragment() 
        fragmentTransaction.replace(R.id.frameLayout_Main,firstFragment).commit()
--------------------------------------------------------------------------------------------------------
NavigationFramework
	Fragmentler arası veri alışverişinde kullanılıuyr
	
res>new > android resource file diyip navigation seçiyorsun

fragmentler için bir host yani bağlayacı birşey lazım onuda activity maine gelip navhostfragment tool unu ekrana yerleştiriyoruz(host)

--------------------------------------------------------------------------------------------------------
fragment sınıfı içerisnde oncreate ve oncreareview a yazılmıyor
onviewcreated a yazılıyor yani görünümler oluşturduktan sonra artık xmldeki button ne yaptıracaksan yaptır
--------------------------------------------------------------------------------------------------------
fragment için aksiyon oluşturma
directon:yön

first_button.setOnClickListener {
            val action=FirstFragmentDirections.actionFirstFragmentToSecondFragment()//firstfragmentyönleri.diyip yön idsini ver
            Navigation.findNavController(it).navigate(action) 
        }
--------------------------------------------------------------------------------------------------------
argümanlarda veri aktarımı(argüman)
	bundle bohça 
		
	navigasyon grafiginden veriyi almak istedigin fragment ına argument oluşturamıyor
	firstfragment a sayfa yonlendirmesi yaparken değeri ata val action=FirstFragmentDirections.actionFirstFragmentToSecondFragment("değer")
	gibi
	daha sonra secondfragment da username bilgisin almak için argument.let parametresini kullan 
	  arguments?.let {
            val userName = SecondFragmentArgs.fromBundle(it).username
            second_textView.text= userName
        }
--------------------------------------------------------------------------------------------------------
try catch
try{
}catch(e:Exception){
	e.primtStackTrace()//hatayı loglarda gösterir
}
--------------------------------------------------------------------------------------------------------
 yerel veritabanı örneğin notlar gibi
execSQL : sql kodu veri ekleme tablo oluşturma gibi
query: veritabanında veri okuma icin yazılan kod
cursor mantıgı: veri hangi column da bilmiyor o yuzden tek tek bakıyor
 try {
            val veritabani = this.openOrCreateDatabase("DB", Context.MODE_PRIVATE,null)
            veritabani.execSQL("CREATE TABLE IF NOT EXISTS urunler (urun_Id INTEGER PRIMARY KEY, urun_Ad VARCHAR, urun_Fiyat INT)")
            //veritabani.execSQL("INSERT INTO urunler(urun_Ad,urun_Fiyat) VALUES ('Ayakkabi',100)")

            val cursor = veritabani.rawQuery("SELECT * FROM urunler",null)
            val getIdColumnIndex=cursor.getColumnIndex("urun_Id")
            val getAdColumnIndex=cursor.getColumnIndex("urun_Ad")
            val getFiyatColumnIndex=cursor.getColumnIndex("urun_Fiyat")

            while (cursor.moveToNext()){
                println(cursor.getInt(getIdColumnIndex))
                println(cursor.getString(getAdColumnIndex))
                println(cursor.getInt(getFiyatColumnIndex))
            }
            cursor.close()

        }catch (e: Exception){
            e.printStackTrace()
        }
--------------------------------------------------------------------------------------------------------
izinler:permission
bazı izinler sadece manifeste yazılıp geciliyor ama bazı tehlikelşi izinler örneğin galeriye ulaşmak gibi ekstra işler yapılıyorS
COntextCompat api verisyonları arasındaki uyumsuzlugu gidermek icin kullanılır

--------------------------------------------------------------------------------------------------------
//resmi veriye cevir
            val outputStream=ByteArrayOutputStream()
            kucukBitmap.compress(Bitmap.CompressFormat.PNG,50,outputStream)
            val byteDizisi=outputStream.toByteArray()
			
//yein veri eklendiginde otomatik olarak listeyi yenileyen kod
listAdapter.notifyDataSetChanged()
