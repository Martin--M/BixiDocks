package com.martinm.sharedocks

import com.google.android.gms.maps.model.LatLng
import java.net.URL

object CityUtils {

    var currentCity: Int = 0

    class CityInfo(
        val country: String,
        val name: String,
        val location: LatLng,
        val baseUrl: URL
    )

    // This should be consistent with the entries under array.xml @cityData & @cityId
    val map: Map<Int, CityInfo> = mapOf(
        1 to CityInfo("CA","Montréal",LatLng(45.5005302, -73.5686184),URL("https://api-core.bixi.com/gbfs/gbfs.json")),
        2 to CityInfo("AE","Abu Dhabi",LatLng(24.4618886,54.597254),URL("https://api-core.bikeshare.ae/gbfs/gbfs.json")),
        3 to CityInfo("AE","Dubai",LatLng(25.074116,55.1453836),URL("https://dubai.publicbikesystem.net/ube/gbfs/v1/gbfs.json")),
        4 to CityInfo("AR","Buenos Aires",LatLng(-34.5957212,-58.3979731),URL("https://buenosaires.publicbikesystem.net/ube/gbfs/v1/gbfs.json")),
        5 to CityInfo("AR","Rosario",LatLng(-32.9583394,-60.6610765),URL("https://www.mibicitubici.gob.ar/opendata/gbfs.json")),
        6 to CityInfo("AT","Innsbruck",LatLng(47.261715,11.3980621),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_si/gbfs.json")),
        7 to CityInfo("AT","Klagenfurt",LatLng(46.6226322,14.3088482),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_ka/gbfs.json")),
        8 to CityInfo("AT","Serfaus",LatLng(47.0399746,10.6025256),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_ta/gbfs.json")),
        9 to CityInfo("AT","Sankt Pölten",LatLng(48.1973939,15.633482),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_la/gbfs.json")),
        10 to CityInfo("AW","Aruba",LatLng(12.5677178,-70.0404427),URL("https://aru.publicbikesystem.net/ube/gbfs/v1/")),
        11 to CityInfo("BA","Banja Luka",LatLng(44.7710349,17.1990896),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_bj/gbfs.json")),
        12 to CityInfo("BA","Sarajevo",LatLng(43.8560941,18.4128164),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_ba/gbfs.json")),
        13 to CityInfo("BA","Zenica",LatLng(44.1994016,17.9164452),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_bz/gbfs.json")),
        14 to CityInfo("BR","Porto Alegre",LatLng(-30.0315683,-51.2295218),URL("https://poa.publicbikesystem.net/ube/gbfs/v1/")),
        15 to CityInfo("BR","Recife",LatLng(-8.0704485,-34.8795331),URL("https://rec.publicbikesystem.net/ube/gbfs/v1/")),
        16 to CityInfo("BR","Rio de Janeiro",LatLng(-22.9177203,-43.1821715),URL("https://riodejaneiro.publicbikesystem.net/ube/gbfs/v1/")),
        17 to CityInfo("BR","Riviera de São Lourenço",LatLng(-23.8020828,-46.0207359),URL("https://riviera.publicbikesystem.net/ube/gbfs/v1/")),
        18 to CityInfo("BR","Salvador",LatLng(-12.9928411,-38.5163082),URL("https://salvador.publicbikesystem.net/ube/gbfs/v1/")),
        19 to CityInfo("BR","São Paulo",LatLng(-23.5903121,-46.6744545),URL("https://saopaulo.publicbikesystem.net/ube/gbfs/v1/")),
        20 to CityInfo("BR","Vila Velha",LatLng(-20.3448293,-40.2852782),URL("https://vilavelha.publicbikesystem.net/ube/gbfs/v1/")),
        21 to CityInfo("CA","Hamilton",LatLng(43.2611048,-79.8591688),URL("https://hamilton.socialbicycles.com/opendata/gbfs.json")),
        22 to CityInfo("CA","Toronto",LatLng(43.6474732,-79.3682274),URL("https://tor.publicbikesystem.net/ube/gbfs/v1/")),
        23 to CityInfo("CA","Vancouver",LatLng(49.2765993,-123.1194087),URL("https://vancouver-gbfs.smoove.pro/gbfs/gbfs.json")),
        24 to CityInfo("CA","Vancouver (UBC)",LatLng(49.2625613,-123.2436639),URL("https://gbfs.hopr.city/api/gbfs/13/")),
        25 to CityInfo("CH","Lucerne",LatLng(47.0450185,8.3148547),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_ch/gbfs.json")),
        26 to CityInfo("CL","Santiago",LatLng(-33.4471706,-70.6322511),URL("https://santiago.publicbikesystem.net/ube/gbfs/v1/gbfs.json")),
        27 to CityInfo("CY","Limassol",LatLng(34.6900533,33.0663045),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_cy/gbfs.json")),
        28 to CityInfo("CY","Nicosia",LatLng(35.1880643,33.3600805),URL("https://nicosia.publicbikesystem.net/ube/gbfs/v1/")),
        29 to CityInfo("CZ","Havířov",LatLng(49.7780793,18.4399142),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_th/gbfs.json")),
        30 to CityInfo("CZ","Ostrava",LatLng(49.8424928,18.302799),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_to/gbfs.json")),
        31 to CityInfo("CZ","Prostějov",LatLng(49.4702745,17.1106269),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_cz/gbfs.json")),
        32 to CityInfo("DE","Augsburg",LatLng(48.3638454,10.9041336),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_ag/gbfs.json")),
        33 to CityInfo("DE","Berlin",LatLng(52.5024617,13.4080552),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_bn/gbfs.json")),
        34 to CityInfo("DE","Buch",LatLng(52.6303706,13.5034172),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_cb/gbfs.json")),
        35 to CityInfo("DE","Bonn (Nextbike)",LatLng(50.7303913,7.1043285),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_bf/gbfs.json")),
        36 to CityInfo("DE","Bonn (NVK)",LatLng(50.7324693,7.101158),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_dr/gbfs.json")),
        37 to CityInfo("DE","Bremen",LatLng(53.0800108,8.8044411),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_wk/gbfs.json")),
        38 to CityInfo("DE","Düsseldorf",LatLng(51.2118113,6.7809488),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_dd/gbfs.json")),
        39 to CityInfo("DE","Erfurt",LatLng(50.9787748,11.0272005),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_ef/gbfs.json")),
        40 to CityInfo("DE","Essen",LatLng(51.4561938,7.0147341),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_mr/gbfs.json")),
        41 to CityInfo("DE","Frankfurt",LatLng(50.1160951,8.684439),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_ff/gbfs.json")),
        42 to CityInfo("DE","Freiburg im Breisgau",LatLng(47.9947128,7.8432888),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_df/gbfs.json")),
        43 to CityInfo("DE","Gießen",LatLng(50.576072,8.6833457),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_ng/gbfs.json")),
        44 to CityInfo("DE","Karlsruhe",LatLng(49.0054491,8.4047668),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_fg/gbfs.json")),
        45 to CityInfo("DE","Kassel",LatLng(51.3140822,9.4826222),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_dk/gbfs.json")),
        46 to CityInfo("DE","Kiel",LatLng(54.3239954,10.1322453),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_sf/gbfs.json")),
        47 to CityInfo("DE","Köln",LatLng(50.9362974,6.9648333),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_kg/gbfs.json")),
        48 to CityInfo("DE","Lahr",LatLng(48.3391029,7.8819476),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_lr/gbfs.json")),
        49 to CityInfo("DE","Leipzig",LatLng(51.3459569,12.3899089),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_le/gbfs.json")),
        50 to CityInfo("DE","Leverkusen",LatLng(51.0349903,6.9965049),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_dw/gbfs.json")),
        51 to CityInfo("DE","Lippstadt",LatLng(51.6661582,8.348657),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_li/gbfs.json")),
        52 to CityInfo("DE","Manheim",LatLng(49.4808872,8.4763574),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_vn/gbfs.json")),
        53 to CityInfo("DE","Mönchengladbach",LatLng(51.1947453,6.4445078),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_sn/gbfs.json")),
        54 to CityInfo("DE","Nürnberg",LatLng(49.4506785,11.0842833),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_dv/gbfs.json")),
        55 to CityInfo("DE","Potsdam",LatLng(52.4005095,13.057995),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_dc/gbfs.json")),
        56 to CityInfo("DE","Usedom",LatLng(54.0523826,14.0049848),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_ur/gbfs.json")),
        57 to CityInfo("DE","Walldorf",LatLng(49.291763,8.6473629),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_ds/gbfs.json")),
        58 to CityInfo("ES","Barcelona",LatLng(41.3885536,2.1810522),URL("https://barcelona.publicbikesystem.net/ube/gbfs/v1/gbfs.json")),
        59 to CityInfo("ES","Bilbao",LatLng(43.2594072,-2.9335308),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_bo/gbfs.json")),
        60 to CityInfo("ES","Ibiza",LatLng(38.9128452,1.4451613),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_ei/gbfs.json")),
        61 to CityInfo("ES","Las Palmas de Gran Canaria",LatLng(28.1107521,-15.4243356),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_el/gbfs.json")),
        62 to CityInfo("ES","Madrid",LatLng(40.4159382,-3.7000715),URL("https://gbfs.bici.madrid/gbfs.json")),
        63 to CityInfo("ES","Maspalomas",LatLng(27.745768,-15.597747),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_ls/gbfs.json")),
        64 to CityInfo("FR","Amiens",LatLng(49.8903547,2.2963899),URL("https://transport.data.gouv.fr/gbfs/amiens/gbfs.json")),
        65 to CityInfo("FR","Avignon",LatLng(43.9464095,4.8115259),URL("https://avignon-gbfs.klervi.net/gbfs/gbfs.json")),
        66 to CityInfo("FR","Cergy-Pontoise",LatLng(49.0342158,2.0789379),URL("https://transport.data.gouv.fr/gbfs/cergy-pontoise/gbfs.json")),
        67 to CityInfo("FR","Clermont-Ferrand",LatLng(45.7742731,3.0947588),URL("https://clermont-gbfs.klervi.net/gbfs/gbfs.json")),
        68 to CityInfo("FR","Créteil",LatLng(48.777139,2.4618487),URL("https://transport.data.gouv.fr/gbfs/creteil/gbfs.json")),
        69 to CityInfo("FR","Lyon",LatLng(45.7610134,4.8599285),URL("https://transport.data.gouv.fr/gbfs/lyon/gbfs.json")),
        70 to CityInfo("FR","Marseille",LatLng(43.2875012,5.3852987),URL("https://transport.data.gouv.fr/gbfs/marseille/gbfs.json")),
        71 to CityInfo("FR","Montpellier",LatLng(43.6012235,3.8785555),URL("https://transport.data.gouv.fr/gbfs/montpellier/gbfs.json")),
        72 to CityInfo("FR","Mulhouse",LatLng(47.7419059,7.3408682),URL("https://transport.data.gouv.fr/gbfs/mulhouse/gbfs.json")),
        73 to CityInfo("FR","Nancy",LatLng(48.6896067,6.1837747),URL("https://transport.data.gouv.fr/gbfs/nancy/gbfs.json")),
        74 to CityInfo("FR","Nantes",LatLng(47.2131971,-1.5498343),URL("https://transport.data.gouv.fr/gbfs/nantes/gbfs.json")),
        75 to CityInfo("FR","Paris",LatLng(48.857136,2.3416912),URL("https://velib-metropole-opendata.smoove.pro/opendata/Velib_Metropole/gbfs.json")),
        76 to CityInfo("FR","Rennes",LatLng(48.1109093,-1.6758675),URL("https://eu.ftp.opendatasoft.com/star/gbfs/gbfs.json")),
        77 to CityInfo("FR","Rouen",LatLng(49.4384379,1.0964858),URL("https://transport.data.gouv.fr/gbfs/rouen/gbfs.json")),
        78 to CityInfo("FR","Saint-Étienne",LatLng(45.4348639,4.3878096),URL("https://saint-etienne-gbfs.klervi.net/gbfs/gbfs.json")),
        79 to CityInfo("FR","Strasbourg",LatLng(48.5775205,7.7532503),URL("https://transport.data.gouv.fr/gbfs/strasbourg/gbfs.json")),
        80 to CityInfo("FR","Toulouse",LatLng(43.5991181,1.4468902),URL("https://transport.data.gouv.fr/gbfs/toulouse/gbfs.json")),
        81 to CityInfo("FR","Valence",LatLng(44.9284261,4.9045394),URL("https://valence.publicbikesystem.net/ube/gbfs/v1/gbfs.json")),
        82 to CityInfo("FR","Vannes",LatLng(47.6546633,-2.7498483),URL("https://vannes-gbfs.klervi.net/gbfs/gbfs.json")),
        83 to CityInfo("GB","Belfast",LatLng(54.5944011,-5.9283907),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_bu/gbfs.json")),
        84 to CityInfo("GB","Uxbridge",LatLng(51.531347,-0.4718381),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_ub/gbfs.json")),
        85 to CityInfo("GB","Cardiff",LatLng(51.4761224,-3.1594436),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_uc/gbfs.json")),
        86 to CityInfo("GB","Edinburgh",LatLng(55.9455737,-3.195196),URL("https://gbfs.urbansharing.com/edinburghcyclehire.com/gbfs.json")),
        87 to CityInfo("GB","Exeter",LatLng(50.7282875,-3.5231669),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_eu/gbfs.json")),
        88 to CityInfo("GB","Glasgow",LatLng(55.858943,-4.2535177),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_gg/gbfs.json")),
        89 to CityInfo("GB","Milton Keynes",LatLng(52.0349516,-0.7506634),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_ku/gbfs.json")),
        90 to CityInfo("GB","Stirling",LatLng(56.1137193,-3.9303241),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_uk/gbfs.json")),
        91 to CityInfo("GB","Swansea",LatLng(51.6126164,-3.9510829),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_uu/gbfs.json")),
        92 to CityInfo("HR","Metković",LatLng(43.0491818,17.645603),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_cm/gbfs.json")),
        93 to CityInfo("HR","Šibenik",LatLng(43.7328059,15.9011966),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_bc/gbfs.json")),
        94 to CityInfo("HR","Sisak",LatLng(45.4721672,16.3753068),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_cs/gbfs.json")),
        95 to CityInfo("HR","Slavonski Brod",LatLng(45.1494617,18.0251171),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_sb/gbfs.json")),
        96 to CityInfo("HR","Split",LatLng(43.5121382,16.4467047),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_gt/gbfs.json")),
        97 to CityInfo("HR","Velika Gorica",LatLng(45.7142481,16.0599339),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_cg/gbfs.json")),
        98 to CityInfo("HR","Zadar",LatLng(44.1206269,15.2335752),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_zd/gbfs.json")),
        99 to CityInfo("HR","Zagreb",LatLng(45.8023087,15.9748957),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_hr/gbfs.json")),
        100 to CityInfo("IN","Bhopal",LatLng(23.2332387,77.4086375),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_bi/gbfs.json")),
        101 to CityInfo("IN","Chennai",LatLng(13.0534955,80.2735215),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_ic/gbfs.json")),
        102 to CityInfo("IN","Delhi",LatLng(28.6072898,77.2223255),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_in/gbfs.json")),
        103 to CityInfo("IN","Hyderabad",LatLng(17.487926,78.39242),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_hi/gbfs.json")),
        104 to CityInfo("IN","Ranchi",LatLng(23.3663017,85.3313746),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_ir/gbfs.json")),
        105 to CityInfo("IT","Verona",LatLng(45.4371768,10.9979542),URL("https://gbfs.urbansharing.com/bikeverona.it/gbfs.json")),
        106 to CityInfo("LB","Byblos",LatLng(34.1182151,35.6479881),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_bl/gbfs.json")),
        107 to CityInfo("LV","Rīga",LatLng(56.9536521,24.1186498),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_lv/gbfs.json")),
        108 to CityInfo("MC","Monaco",LatLng(43.7335769,7.4255538),URL("https://monaco.publicbikesystem.net/ube/gbfs/v1/gbfs.json")),
        109 to CityInfo("MT","Malta",LatLng(35.9024518,14.5042467),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_mt/gbfs.json")),
        110 to CityInfo("MX","Guadalajara",LatLng(20.6760214,-103.3655642),URL("https://guad.publicbikesystem.net/ube/gbfs/v1/")),
        111 to CityInfo("NL","Dordrecht",LatLng(51.8051136,4.6701229),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_nd/gbfs.json")),
        113 to CityInfo("NO","Bergen",LatLng(60.3892602,5.3253297),URL("https://gbfs.urbansharing.com/bergenbysykkel.no/gbfs.json")),
        114 to CityInfo("NO","Oslo",LatLng(59.912364,10.754939),URL("https://gbfs.urbansharing.com/oslobysykkel.no/gbfs.json")),
        115 to CityInfo("NO","Trondheim",LatLng(63.4273202,10.399161),URL("https://gbfs.urbansharing.com/trondheimbysykkel.no/gbfs.json")),
        116 to CityInfo("NZ","Auckland",LatLng(-36.849371,174.762430),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_nz/gbfs.json")),
        117 to CityInfo("PL","Chorzów",LatLng(50.2933768,18.954534),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_pv/gbfs.json")),
        118 to CityInfo("PL","Grodzisk Mazowiecki",LatLng(52.1019355,20.6329584),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_gp/gbfs.json")),
        119 to CityInfo("PL","Kołobrzeg",LatLng(54.1747198,15.5659146),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_kr/gbfs.json")),
        120 to CityInfo("PL","Konin",LatLng(52.2163733,18.2578958),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_pn/gbfs.json")),
        121 to CityInfo("PL","Legnica",LatLng(51.1999432,16.1647822),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_mp/gbfs.json")),
        122 to CityInfo("PL","Łódź",LatLng(51.7592795,19.4630664),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_pw/gbfs.json")),
        124 to CityInfo("PL","Marki",LatLng(52.3272512,21.1116715),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_mk/gbfs.json")),
        125 to CityInfo("PL","Ostrów Wielkopolski",LatLng(51.6492259,17.8188406),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_po/gbfs.json")),
        126 to CityInfo("PL","Piaseczno",LatLng(52.0716924,21.0327588),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_pi/gbfs.json")),
        127 to CityInfo("PL","Pielgrzymka",LatLng(51.096945,15.776382),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_pg/gbfs.json")),
        128 to CityInfo("PL","Poznań",LatLng(52.4048185,16.9276842),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_pb/gbfs.json")),
        129 to CityInfo("PL","Sosnowiec",LatLng(50.2807687,19.1267777),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_pr/gbfs.json")),
        130 to CityInfo("PL","Szczecin",LatLng(53.4272595,14.5505481),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_sp/gbfs.json")),
        131 to CityInfo("PL","Tarnów",LatLng(50.011696,20.9874132),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_tn/gbfs.json")),
        132 to CityInfo("PL","Warszawa",LatLng(52.2406516,21.0089915),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_vp/gbfs.json")),
        133 to CityInfo("PL","Wrocław",LatLng(51.1052817,17.0389716),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_pl/gbfs.json")),
        134 to CityInfo("SA","King Abdullah Economic City",LatLng(22.404705,39.079153),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_sa/gbfs.json")),
        135 to CityInfo("SE","Göteborg",LatLng(57.6997624,11.9687595),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_zg/gbfs.json")),
        136 to CityInfo("SI","Celje",LatLng(46.2337147,15.2655918),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_cn/gbfs.json")),
        137 to CityInfo("SK","Nitra",LatLng(48.3014448,18.0878021),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_as/gbfs.json")),
        138 to CityInfo("SK","Žilina",LatLng(49.2185112,18.7455402),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_ak/gbfs.json")),
        139 to CityInfo("UA","Lviv",LatLng(49.8293973,24.0294482),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_nu/gbfs.json")),
        140 to CityInfo("UA","Vinnytsia",LatLng(49.2300097,28.4632513),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_uv/gbfs.json")),
        141 to CityInfo("US","Aspen",LatLng(39.190908,-106.8200276),URL("https://asp.publicbikesystem.net/ube/gbfs/v1/")),
        142 to CityInfo("US","Atlanta",LatLng(33.772262, -84.363670),URL("https://relaybikeshare.socialbicycles.com/opendata/gbfs.json")),
        143 to CityInfo("US","Austin",LatLng(30.2732901,-97.7432813),URL("https://gbfs.bcycle.com/bcycle_austin/gbfs.json")),
        144 to CityInfo("US","Aventura",LatLng(25.9541275,-80.1322204),URL("https://gbfs.bcycle.com/bcycle_aventura/gbfs.json")),
        145 to CityInfo("US","Battle Creek",LatLng(42.3088002,-85.1890529),URL("https://gbfs.bcycle.com/bcycle_battlecreek/gbfs.json")),
        146 to CityInfo("US","Boston",LatLng(42.3506913,-71.0578628),URL("https://gbfs.bluebikes.com/gbfs/gbfs.json")),
        147 to CityInfo("US","Boulder",LatLng(40.0084036,-105.2555376),URL("https://gbfs.bcycle.com/bcycle_boulder/gbfs.json")),
        148 to CityInfo("US","Buffalo",LatLng(42.896267, -78.868747),URL("https://reddybikeshare.socialbicycles.com/opendata/gbfs.json")),
        149 to CityInfo("US","Charlotte",LatLng(35.223047, -80.843833),URL("https://gbfs.bcycle.com/bcycle_charlotte/gbfs.json")),
        150 to CityInfo("US","Chattanooga",LatLng(35.04079,-85.3065826),URL("https://chat.publicbikesystem.net/ube/gbfs/v1/")),
        151 to CityInfo("US","Chicago",LatLng(41.8789647,-87.6222822),URL("https://gbfs.divvybikes.com/gbfs/gbfs.json")),
        152 to CityInfo("US","Cincinnati",LatLng(39.100681, -84.512536),URL("https://gbfs.bcycle.com/bcycle_cincyredbike/gbfs.json")),
        153 to CityInfo("US","Clarksville",LatLng(36.530190, -87.361945),URL("https://gbfs.bcycle.com/bcycle_clarksville/gbfs.json")),
        154 to CityInfo("US","Clemson",LatLng(34.6708776,-82.8289053),URL("https://gbfs.bcycle.com/bcycle_clemson/gbfs.json")),
        155 to CityInfo("US","Columbus",LatLng(39.9584217,-82.9989455),URL("https://gbfs.cogobikeshare.com/gbfs/gbfs.json")),
        156 to CityInfo("US","Des Moines",LatLng(41.5814411,-93.615861),URL("https://gbfs.bcycle.com/bcycle_desmoines/gbfs.json")),
        157 to CityInfo("US","Detroit",LatLng(42.331427, -83.0457538),URL("https://det.publicbikesystem.net/ube/gbfs/v1/")),
        158 to CityInfo("US","El Paso",LatLng(31.7588678,-106.4913916),URL("https://gbfs.bcycle.com/bcycle_elpaso/gbfs.json")),
        159 to CityInfo("US","Fort Lauderdale",LatLng(26.113468,-80.1357668),URL("https://gbfs.bcycle.com/bcycle_broward/gbfs.json")),
        160 to CityInfo("US","Fort Worth",LatLng(32.7448391,-97.3282934),URL("https://gbfs.bcycle.com/bcycle_fortworth/gbfs.json")),
        161 to CityInfo("US","Freemont",LatLng(37.542962,-121.9879363),URL("https://gbfs.hopr.city/api/gbfs/16/")),
        162 to CityInfo("US","Greenville",LatLng(34.8468708,-82.3982958),URL("https://gbfs.bcycle.com/bcycle_greenville/gbfs.json")),
        163 to CityInfo("US","Honolulu",LatLng(21.2908529,-157.8468151),URL("https://hon.publicbikesystem.net/ube/gbfs/v1/")),
        164 to CityInfo("US","Houston",LatLng(29.7604267, -95.3698028),URL("https://gbfs.bcycle.com/bcycle_houston/gbfs.json")),
        165 to CityInfo("US","Indianapolis",LatLng(39.768403, -86.158068),URL("https://gbfs.bcycle.com/bcycle_pacersbikeshare/gbfs.json")),
        166 to CityInfo("US","Jackson",LatLng(43.4726,-110.7736),URL("https://gbfs.bcycle.com/bcycle_startbike/gbfs.json")),
        167 to CityInfo("US","Kona",LatLng(19.6285453,-155.9834819),URL("https://kona.publicbikesystem.net/ube/gbfs/v1/")),
        168 to CityInfo("US","Las Vegas",LatLng(36.165450, -115.138386),URL("https://gbfs.bcycle.com/bcycle_rtcbikeshare/gbfs.json")),
        169 to CityInfo("US","Lincoln",LatLng(40.8151601,-96.7043554),URL("https://gbfs.bcycle.com/bcycle_bikelnk/gbfs.json")),
        170 to CityInfo("US","Los Angeles",LatLng(34.0522342, -118.2436849),URL("https://gbfs.bcycle.com/bcycle_lametro/gbfs.json")),
        171 to CityInfo("US","Louisville",LatLng(38.2526647, -85.7584557),URL("https://lou.publicbikesystem.net/ube/gbfs/v1/")),
        172 to CityInfo("US","Madison",LatLng(43.0674331,-89.4115188),URL("https://gbfs.bcycle.com/bcycle_madison/gbfs.json")),
        173 to CityInfo("US","McAllen",LatLng(26.2034071, -98.2300124),URL("https://gbfs.bcycle.com/bcycle_mcallen/gbfs.json")),
        174 to CityInfo("US","Memphis",LatLng(35.1423138,-90.0459995),URL("https://gbfs.bcycle.com/bcycle_memphis/gbfs.json")),
        175 to CityInfo("US","Milwaukee",LatLng(43.0383787,-87.9110402),URL("https://gbfs.bcycle.com/bcycle_bublr/gbfs.json")),
        176 to CityInfo("US","Minneapolis",LatLng(44.977753, -93.2650108),URL("https://gbfs.niceridemn.com/gbfs/gbfs.json")),
        177 to CityInfo("US","New York",LatLng(40.7431773,-73.986535),URL("https://gbfs.citibikenyc.com/gbfs/gbfs.json")),
        178 to CityInfo("US","Omaha",LatLng(41.250607, -95.951373),URL("https://gbfs.bcycle.com/bcycle_heartland/gbfs.json")),
        179 to CityInfo("US","Orlando",LatLng(28.541350, -81.377933),URL("https://gbfs.hopr.city/api/gbfs/12/")),
        180 to CityInfo("US","Philadelphia",LatLng(39.9525839, -75.1652215),URL("https://gbfs.bcycle.com/bcycle_indego/gbfs.json")),
        181 to CityInfo("US","Phoenix",LatLng(33.455776,-112.0739243),URL("https://grid.socialbicycles.com/opendata/gbfs.json")),
        182 to CityInfo("US","Pittsburgh",LatLng(40.4436837,-79.9912726),URL("https://gbfs.nextbike.net/maps/gbfs/v1/nextbike_pp/gbfs.json")),
        183 to CityInfo("US","Portland",LatLng(45.5186028,-122.6795906),URL("https://gbfs.biketownpdx.com/gbfs/gbfs.json")),
        184 to CityInfo("US","Salt Lake City",LatLng(40.7563078,-111.8902742),URL("https://gbfs.bcycle.com/bcycle_greenbikeslc/gbfs.json")),
        185 to CityInfo("US","San Antonio",LatLng(29.4178916,-98.4892824),URL("https://gbfs.bcycle.com/bcycle_sanantonio/gbfs.json")),
        186 to CityInfo("US","San Francisco Bay Area",LatLng(37.7780906,-122.4058823),URL("https://gbfs.baywheels.com/gbfs/gbfs.json")),
        187 to CityInfo("US","San Ramon",LatLng(37.7586196,-121.958027),URL("http://britebikes.socialbicycles.com/opendata/gbfs.json")),
        188 to CityInfo("US","Santa Barbara",LatLng(34.4096915,-119.8420952),URL("https://gbfs.hopr.city/api/gbfs/5/")),
        189 to CityInfo("US","Santa Monica",LatLng(34.0174395,-118.479121),URL("http://santamonicabikeshare.com/opendata/gbfs.json")),
        190 to CityInfo("US","Spartanburg",LatLng(34.9516242,-81.9273243),URL("https://gbfs.bcycle.com/bcycle_spartanburg/gbfs.json")),
        191 to CityInfo("US","St. Petersburg",LatLng(27.7664674,-82.642197),URL("http://coast.socialbicycles.com/opendata/gbfs.json")),
        192 to CityInfo("US","Tampa",LatLng(27.950575, -82.4571776),URL("https://gbfs.hopr.city/api/gbfs/8/")),
        193 to CityInfo("US","Tempe",LatLng(33.4204302,-111.9320928),URL("https://grid.socialbicycles.com/opendata/gbfs.json")),
        194 to CityInfo("US","Tucson",LatLng(32.2221959,-110.9687969),URL("https://tuc.publicbikesystem.net/ube/gbfs/v1/")),
        195 to CityInfo("US","Washington",LatLng(38.9046129,-77.036403),URL("https://gbfs.capitalbikeshare.com/gbfs/gbfs.json"))
        )
}