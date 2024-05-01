package me.ramazanbulbul.diet.ui.dp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import me.ramazanbulbul.diet.R;
import android.widget.AdapterView.OnItemClickListener;
public class DPFragment extends Fragment {

    private DPViewModel dpViewModel;
    private String[] dietList =
            {"Atkins Diyeti", "Dukan Diyeti", "Karatay Diyeti", "Weight Watchers Diyeti","Alkali Beslenme",
                    "Vegan Beslenme", "Akdeniz Diyeti", "İsveç Diyeti", "Paleo Diyet", "Ender Saraç Diyeti",
                    "Şeyda Coşkun Diyeti", "Ferin Batman’dan detoks programı"};
    private String[] dietDetail =
            {"Sağlıklı olup olmadığı en çok tartışılan diyetlerden biri de; Dr. Atkins’in listesi. Diyetin temeliyse, aldığınız karbonhidrat miktarını oldukça düşük tutmak ve protein bakımından zengin beslenmek üzerine kurulu. Dr. Atkins’e göre bu tarz bir beslenme şekliyle yağ yakmamak imkânsız. Zira vücut, temel enerji kaynağı, karbonhidrattan mahrum kaldığında enerji açığını kapatmak için yağları kullanmaya başlıyor.  Başlangıç aşamasında ilk 14 gün, kafein başta olmak üzere, meyve, ekmek, tahıl, makarna ya da nişastalı sebzelerin olmadığı ve daha sonraki aşamalarda azar azar listeye eklendiği diyette iki hafta gibi kısa bir sürede kilo vermek mümkün. Ancak diyetisyenlerin diyetin geçerliliği konusunda ikiye ayrıldıklarını hatırlatmakta fayda var.",
                    "Pierre Dukan’ın yarattığı diyetin milyonlarca takipçisi var. Diyetin temeli, yüzde 40 protein, yüzde 60 sebze… Başlangıç aşaması adı verilen bir haftalık evrede sadece protein tüketiyorsunuz. Seyir dönemi adı verilen ikinci evredeyse protein ve sebzeyi beraber yiyebiliyorsunuz. Üstelik saat kaçta yediğiniz önemi olmadığı gibi herhangi bir porsiyon kısıtlaması da yok. Tüm bu evrelerde yulaf kepeği dışında herhangi bir karbonhidrat alımı söz konusu değil. Güçlendirme dönemi adı verilen aşamada, listeye yavaş yavaş meyve ve karbonhidrat ekleyebiliyorsunuz. En son aşama koruma evresiyse, haftanın bir günü sadece protein tüketmek kaydıyla hiçbir kısıtlama getirmiyor. Çoğu diyetisyene göre bu diyeti uygulamak çok büyük bir risk. Zira aşırı protein tüketiminin insan sağlığı üzerinde olumsuz etkileri oldukça fazla.",
                    "Gelelim günümüzün en popüler diyetine… Bu beslenme programının mucidi Prof. Dr. Canan Karatay, diyet hakkında tüm bilinenleri alt üst ediyor. Karatay’a göre “az az, sık sık” yemek insülin direncine neden oluyor. Bu nedenle arada en az dört saat olacak şekilde üç öğün büyük porsiyonlar tüketmemiz gerekiyor. Özellikle sabah kahvaltısı en kuvvetli yapılması gereken öğün. Unutmadan diyette ekmek, meyve, şeker, beyaz un, gazlı içecekler ve paketlenmiş ürünlerin tüketilmesi kesinlikle yasak. Köy tereyağı, soğuk sıkım zeytinyağı ve zeytin diyetin olmazsa olmazı. Ara öğün yapmadan duramayanlar da fındık, fıstık, ceviz, badem gibi kuruyemişleri bol bol tüketebilirler.",
                    "Dünyanın en popüler diyeti kabul edilen Weight Watchers; cinsiyet, yaş, kilo, boy ve günlük egzersiz miktarı üzerinden puan hesaplamak ve bu puana uygun olarak hazırlanan besin katoloğundan kendi listenizi yaratmak üzerine kurulu. Diyette dikkat etmeniz gereken tek şey, beslenme programınızın bu puanı kesinlikle geçmemesi. Bunun için de et ve peynir başta olmak üzere besinlerin gramajını ayarlamak çok önemli.",
                    "Asitli gıdaları, beslenme programımızdan çıkarmaya yönelik alkali beslenme, bağışıklık sistemini kuvvetlendiren bir diyet olarak da biliniyor. Alkali Diyeti’nin ana mantığı, insan vücudunda yer alan ph değerinin asit yönünü alkali yönüne çevirmek. Haliyle bu programda kızartmalara, rafine gıdalara, üç beyaza asla yer yok. Diyetin ilk üç günü çiğ meyve ve sebze tüketilirken geri kalan günlerde sadece sebze ve meyve suyu içilen detoks programı uygulanıyor. Diyetin olmazsa olmazıysa, iki litre suya bir tatlı kaşığı İngiliz karbonatı eklediğimiz sudan sabah aç karnına içmek. Bu suyu çay ve yemeklerde kullanabilirsiniz.",
                    "En sağlıklı beslenme tipi olarak atfedilen diyette, hayvansal ürün tüketilmediği gibi bu hayvanlardan elde edilen herhangi bir ürünü kullanmak da mümkün değil. Süt, kaymak, peynir, yoğurt, tereyağı, yumurta, bal bunlardan bir kaçı… Üstelik veganlık, bir beslenme şekli olmasının yanında yaşam felsefesini de ifade ettiğinden bu yaşamı seçenler; deri, yün, kaz tüyü gibi tekstil malzemelerini de asla kullanmıyor. Hal böyle olunca herkesin aklına şu soru geliyor: “Veganlar, protein ihtiyacını nasıl karşılıyor?” Hatırlatmak da fayda var; protein sadece hayvansal gıdalarda bulunmuyor. Kuru baklagiller, yağlı tohumlar, tahıllar ve sebzeler de protein ihtiyacımızı karşılayabilir.",
                    "Sağlık otoriteleri tarafından tartışmasız en sağlıklı diyet kabul edilen Akdeniz tipi beslenmenin, kalp ve damar sağlığı başta olmak üzere pek çok soruna karşı ciddi koruyucu etkileri var. Diyetin olmazsa olmaz malzemeleri arasındaysa, mevsim meyve ve sebzeleri, tavuk, balık ve Akdeniz’in vazgeçilmezi zeytin yağ bulunuyor. Kuru baklagiller ve tam tahıllı yiyecekler de ölçülü olarak diyete",
                    "Bu diyet, metabolizmayı tamamen değiştirdiği için iki hafta gibi kısa bir sürede yedi ile 20 arasında kilo kaybetmek mümkün. Ancak pek de sağlıklı bir yöntem olmadığını belirtmekte fayda var. Zira diyet Amerikan Kalp Vakfı tarafından acilen kilo vermeleri gereken kalp hastalarına uygulanıyor. Katı bir beslenme programına sahip olan İsveç Diyetinde belirtilen ölçüler dışında çay, kahve ve meşrubat içilmesi de yasak. Bu arada hatırlatmakta fayda var. Diyetin 13 günden fazla uygulanması ciddi sağlık problemlerinin ortaya çıkmasına sebep oluyor.",
                    "Sporcuların vazgeçilmezi Paleo Diyet, adını Paleolitik Çağ’dan alıyor. Doğal beslenmiş hayvanların eti, balık/deniz ürünleri, taze meyve ve sebzeler, yumurta, yemiş ve tohumlu yiyecekler, sağlıklı yağlar (Zeytin, ceviz, keten tohumu, Avustralya fındığı, avokado, Hindistan cevizi) diyetin olmazsa olmazı. Uzak durulması gereken besinler de; tam taneli tahıl, baklagiller, süt ürünleri, rafine şeker, patates, işlemden geçmiş yiyecekler, tuz ve işlenmiş Ayçiçek yağı.",
                    "Çok çabuk sabah kahvaltısı yapamayanlardansanız, bu diyet tam size göre. Her sabah yarım tatlı kaşığı bal ve 8-10 damla limon suyu ilave edilen ılık suyu içtikten tam yarım saat sonra kahvaltıya başlıyorsunuz. Ara öğünlerde özellikle yağ yakan meyveler olarak da bilinen ananas, çilek, erik, elma gibi meyveleri bol bol tüketebilirsiniz. Öğünler genellikle yağsız et ve mevsime uygun sebze yemeklerinden oluşuyor. Sindirim sisteminin en çok çalıştığı öğle saatleri de porsiyonun en geniş olduğu öğün…",
                    "Ünlülerin yaşam koçu olarak tanınan ve Hadise’yi zayıflatarak gündeme yerleşen Şeyda Coşkun, günde en az bir saat yürüyüşle beraber yapılan diyet programının mucidi. Bu diyette haftada bir gün tamamen protein tüketirken öğlen 16.00’a kadar da bol bol yeşil çay içiyorsunuz. Diyette rafine ve paketlenmiş gıdaların tüketilmesi kesinlikle yasak.",
                    "Günümüzün hızlı yaşam koşullarının, sağlıksız alışkanları vücutta ödem oluşmasına neden olabiliyor. Bu da metabolizmanın yavaşlamasının yanında ciddi karaciğer ve böbrek sorunları yaratıyor. Beslenme ve Diyet Uzmanı Ferin Batman, içlerinden kendinize en uygun olanı seçebileceğiniz detoks programlarıyla imdada yetişiyor. Unutmamak gerekir ki, sağlıklı yaşama ilk adım detoksla atılır. Ancak herkesin detoks yapamayacağını da hatırlatalım. Hamileler ve emziren anneler, sistemik, ağır ve uzun süreli hasatlığı olanlar (şeker ve inflamatuar bağırsak hastalığı), bağışıklık yetmezliği sorunu olanlar, 18 yaş altında, 80 yaş üstünde olanlar için detoks zararlı olabilir."};
    private int[] dietImage =
            {R.drawable.atkins, R.drawable.dukan, R.drawable.karatay, R.drawable.ww3, R.drawable.alkali,
                    R.drawable.vegan, R.drawable.akdeniz, R.drawable.isvec,R.drawable.paleo, R.drawable.ender,
                    R.drawable.seyda, R.drawable.ferin};


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dpViewModel =
                ViewModelProviders.of(this).get(DPViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_dp, container, false);

        ListView listemiz= root.findViewById(R.id.listView1);

        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>
                (root.getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, dietList);

        listemiz.setAdapter(veriAdaptoru);


        listemiz.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                DPDetailFragment fragmentAndroid = new DPDetailFragment();
                Bundle args = new Bundle();
                args.putString("dietTitle", dietList[position]);
                args.putInt("dietImage", dietImage[position]);
                args.putString("dietDetail", dietDetail[position]);
                fragmentAndroid.setArguments(args);
                ft.replace(R.id.nav_host_fragment, fragmentAndroid);
                ft.addToBackStack(null);
                ft.commit();

            }
        });

        return root;
    }
}