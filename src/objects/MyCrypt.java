package objects;

public class MyCrypt {

    private final int lengthTable = 1103;
    private int key;

    public MyCrypt(int key){
        this.key = key;
    }

    public String encrypt(String strEncrypted){

        String strResult = encryptByte(encryptCaesar(strEncrypted));

        return strResult;
    }

    public String decrypt(String strDecrypted){

        String strResult = decryptCaesar(decryptByte(strDecrypted));

        return strResult;

    }

    private String encryptCaesar(String strEncrypted){

        String strResult = "";
        int i = 0;

        while(i<strEncrypted.length()){

            int index = (int)strEncrypted.charAt(i);
            int offset = index + key;
            if( offset >= lengthTable ){
                strResult = strResult + (char)(offset-lengthTable);
            }else
                strResult = strResult + (char)(offset);

            i++;
        }

        return strResult;

    }

    private String decryptCaesar(String strDecypted){

        String strResult="";
        int i = 0;

        while(i<strDecypted.length()){

            int index = (int)strDecypted.charAt(i);
            int offset = index - key;
            if( offset <= 0 ){
                strResult = strResult + (char)(lengthTable + offset);
            }else
                strResult = strResult + (char)(offset);

            i++;

        }
        return strResult;
    }

    private String encryptByte(String strEncrypted){

        int[] arrEncypted = getInts(strEncrypted);
        int[] arrResult = new int[arrEncypted.length];
        for(int i = 0; i < arrEncypted.length;i++){

            arrResult[i] =~ arrEncypted[i];

        }

        return intToString(arrResult);
    }

    private String decryptByte(String strDecrypted){

        int[] arrDecrypted = getInts(strDecrypted);
        int[] arrResult = new int[arrDecrypted.length];
        for(int i = 0; i < arrDecrypted.length;i++){

            arrResult[i] = ~arrDecrypted[i];

        }

        return intToString(arrResult);
    }

    private int[] getInts(String strGeted){

        int[] arrResult = new int[strGeted.length()];
        for(int i = 0; i<strGeted.length(); i++){

            arrResult[i] = (int)(strGeted.charAt(i));
        }


        return arrResult;
    }

    private String intToString(int[] arrConverted){

        String strResult = "";

        for(int i = 0; i<arrConverted.length; i++){
            strResult = strResult + (char)arrConverted[i];
        }

        return strResult;
    }

}
