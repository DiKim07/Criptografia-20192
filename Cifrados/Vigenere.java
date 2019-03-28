
public class Vigenere {

    static String alfabetoMayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
  
    private static String codificar(String cadena, String llave) {
        String rtnCadena = "";

        for (int i=0, j=0, l=llave.length(); i<cadena.length(); i++, j=i%l) {
            if( alfabetoMayusculas.contains( String.valueOf(cadena.charAt(i)) ) ){
                int Xi = alfabetoMayusculas.indexOf(cadena.charAt(i));
                int Ki = alfabetoMayusculas.indexOf(llave.charAt(j));
                // E(x)= ( Xi + Ki ) mod L
                int Ex = ( Xi + Ki ) % alfabetoMayusculas.length();
                char cipherChar = alfabetoMayusculas.charAt(Ex);

                rtnCadena += cipherChar; 
            }else{
                rtnCadena += cadena.charAt(i); 
            }
        }

        return rtnCadena;
    }


    private static String decodificar(String cadena, String llave) {
        String rtnCadena = "";

        for (int i=0, j=0, l=llave.length(); i<cadena.length(); i++, j=i%l) {
            if( alfabetoMayusculas.contains( String.valueOf(cadena.charAt(i)) ) ){

                int Ci = alfabetoMayusculas.indexOf(cadena.charAt(i));
                int Ki = alfabetoMayusculas.indexOf(llave.charAt(j));
                int Dx = 0;

                if ((Ci-Ki) >= 0){
                	Dx = (Ci-Ki);
                }else{
                	Dx = alfabetoMayusculas.length() + (Ci-Ki);
                }

                char cipherChar = alfabetoMayusculas.charAt(Dx);
                rtnCadena += cipherChar; 

            }else{
                rtnCadena += cadena.charAt(i); 
            }
        }
        return rtnCadena;
    }


    /**
     * Método principal
     */
    public static void main(String[] args) {
        String mensaje = "FUDPBVEQAHKEYECSUQWSKMBPFVIPDQNAETSPLMUOEUXIOFDQRWGNOXOUHQCCVAPDEWEQCZQSXXPTOESSEAXRINOBPFVEZSSSUQTZEOZYIPTASSNOECIOEDDGTEMASUEEJBEAYECAJMBOUDQBIGSFGOPQGTZQEEECTLAFIGSAACGXTXPGNEJGRRAEWGDMSSUYVPACSPTAWEEIFCNCJSNOETGAACJSPOQHHCNETBEIXACRODFIGHMNEWEODBUTDJWTEXROOPASSNOECIOEDDGTEMASUYQHCKMBAWEAYPBGJMGSNCACQGPFDRGSGRSUIACSUDQROWCTNJGAYDGGNFDBEEEFIGCABSPTMCZQSMJHQRQHHQMYPDQSFDZASBXJCCQAGKSFTACOOPAROPTZQSZJAGRAHFGAXTGGSGCCFEXDGEOZRSRTAHTWNPPAGNFPZGSPTZCMMISOAFXQCUZTGVUPXCTISJFQSANSZHMJGVIHDRGLMCONIEXGOAFTACTURCTECJSTIDXONAUCQNUEXCPDQJBCDQUWPIOXCPCGXRCDAHOFEXHWINUUWEAPDRGLZJAGRAGSCLGCOFIERIUIACFGLMIWXAMAOEOZHHTUORWQNPTZQSZJAGRAHFGAXTGAUZPSZPAHWEIACRGSUHDTIZRWRAXTGRRAEWGDMSSUSUQWGNQHHCSZDQKOZTGDAEXQCSODBUTUIIAEZJBCPMGHGMGNWPTQGSUAZISFEXDGHUZSOOEZICUDQAOUMMISOAFXQCSZDGGRMCHTAFPRCSMFIKCACRGTMAZGEZGSCLUSOFEZAOOAKDFKAPTZCSRPGGSPTZCNMAWUIEBOUQGTZQSYTHQDAHIUAPDGGNXPQQNEIFWCOXCPDQAQCMBDRGLAHBWMQGCURQPZGSZDGKNFTFGSMCGWSBGCRIQSOFEEECTLAIOPTAICOADTAQSGCDGQGTBQGDJDQDQPLKOYPGFEXDGEUMASUPGTRGNPTRWCUGGGTASOULMHDTOBXSFAPTGFEXDGPUYTFQSDTONEEEOTAMWCPDMGSPLAHAGTASCUUFXZKZMSCUEZAOEOZHHTUORWQNPTZEAYECTEMASNLQRHQRPTPGRUPQQNEJZVADAOURQUSTEZRWCSNXPNIAVFCFUROUDQATKNMARGLOPDKTGACGLFXHWLASSGSFTQCPUIINOQMDTEEPSPPAROUPMAODRMHZQSODBQCUBWGNFDGOAFTACTURCUNQRSUADXCUPMGONEQGSUTQAWDRASSJEOWCGSFTQQRFDQCPUIINOQHGKMBASOEZISWNMTLRLUROEIACRGLAFIGSQTBVIQCRGPAGDTOBXSFAPTGDAEXQCSPTZQSZJAGRAHHQDMHZCSOJONEEHIOAKBINTUEZKCMRWQNDTGVAKSWXIEXCPRQHCNUOXCPDQTQWAOXCPEEUOETAGWBAOXCPYAIFQSBGCEEEDGCLSTPTAURCUNAHGQNKPQQNARWFAEHWPEYQOTGATGVEOPDKTGACPOQHIPRQEOUOMESUADSSNOODBQCUSCFEXPACTQGWCLMTLRLAGOEIACEWEHPAQSMTARRQCRGRQHDTONPPNECJSRADTNEAZDJGDMSBQSQIFCTMSSRRQHSPTMGIPADTJKSUDBRRAAWLAPTACTQGWCSFGOFIOXCPAXTGUIZDRGSUCHGRUOOTEEISXIQYCUANTFGNGCFGDGRWFOPTDTOBXSFAPTGUEZRWNLMHDCRMHSTMQCQKOZPRCSBTFQVMPFGSGAHCRCJSWNEDFRRQCRGNFTBWMQGCFEPXJGREDGJEOWCUIYECTTMCHGSETCDTQCRTAODAQCACGGCGTBEIMSSNAEFIGVMBCUAPTGVAOPFFEXPGFOOTDTOBXSFAPTGSUQKOOOEPSUTGSWCRQCSUTQRORIFJZQLMHBWEHTDTIYTFCSETFGFUTFGNMAOUOBTFCCUDBGSRJBFAYTBVAXTGFEEJACYYJZVIBAWEAOXCPATDFCVQPAQSXDEWEPXQGPUHYWNAKIPOPTZQSODBEEBICUFGCRCMQCHCLQHRGLMHACTQBOVIOPGGSQABWMQGCGLODBEEBICFEZJAGRAHITGUDSPLMPBVISJSFAPPARLUPBFOETMIEZTFCLUOOPDAHSEOZTZVIQBDQLAHBWMQGCUEZISTOEITTAORWQNQHGGLXPACNZJAGRAHFCCUDBCLQHSNNGBSTODPQKOZPZRUQSSGXBDBGRETQQMAAOTALDBFEXDGPUYTFQSQCHGRAHDAQFPZGSCJSRYCHCPPDXAQSDTZCTUKCUEEICUNGBSTOEEIGDQCFGPDTGGNFPFUEBDFHRMRQKOZTGREDXCFIOPGHIZXHCSAXBHIZXHCSXDGPUYTFQSCJSPOFXSPEZJBCEJEOUIACRGCUBONCURZKCMHSNEEAZCMMXFTAOXCPAXTGGLODBLUZICSUQGSUUXIOFEXPIPIACRGLAHFCCUDBCLQHQQNXDGKRDPQKOZPZGSETZGLXPACCACXWNFDRGLAHBWMQGCURQPZGSQCSUTMEOTTQTJCDQTZCUFDFVOOPFGLBJBVOPDBFEETQQNEIFWYQCZQSZJAGRAHFGAXTGNAODBELGHWQNQHEWEZXBIUZAWDRASSEAXRINOXDHTAFPFCPGTGGSHTFFAPHCNOZDGKMBDFVAXPQQMBASVELSSNOECIOEDDGTEMASUPMGOCSQVITADFIGEJXGVAZACULUBWVEE";
        String llave   = "CAMPO";
        // 3. Decodificar
        String cadenaDecodificada = decodificar(mensaje, llave); 
        System.out.println("Texto decodificado: " + cadenaDecodificada); 
    }

}