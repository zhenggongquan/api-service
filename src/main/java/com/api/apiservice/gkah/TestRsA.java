package com.api.apiservice.gkah;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.xml.crypto.dsig.Transform;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;

import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;

public class TestRsA {
    /**
     * 加密算法RSA
     */
    public static final String KEY_RSA = "RSA";
    private static final int MAX_DECRYPT_BLOCK = 2048;

    public static String Decrypt(String encryString) throws Exception {
        String outString = null;
        String key = "naMThpS71rmjMMYBFDOrLxdRDl/FGjeQl3gYt6UCPaXajoSKzs/LsM45RVz0h77JU9AV5dce0JCa7hu0IMtEp7adE7nbkQOOHeF8onEPqpkP/XjlDCsRyDFQHUkCkNEzxKpzUYaIpbLy1aper324kIDacp2ejPjXmdqpBKl1PTHnCow9MaJbdINH1jo/3oDoPSbsYvrtwu5mMPAVFpB8ka8DxqbQDqS/LlSSBLFjiyJSBHAOIJ7BBWmN1Xy/AaW4xs83QZJCtPeiL99pmAwVwPQ0qu2u+7KEQ+IQmCg0icOu33yB+J+FSflD77Ip0fQ1tnPv+K0mOJWaYK7uOpVsnQ==</Modulus><Exponent>AQAB</Exponent><P>0efLnfqCBsu7VG4Uw9ZElmwqDSI5TcpDcv1fnRYJQ3ymKWnwwHfZ5NBQLxiXoL1DRj+wi7KQLhtadZepfV03Tn2IwflTq3fb2fc0jjNfP1WGXxq3bdDVLriJ8fjar8a1rxcIyVZGrvt2FNw6k14A1kGpICXFSRp/EWSkpIRTEOc=</P><Q>wEDrN2JafCLon1wLyiuE7N1zma8vxDAnuz5rY4fcOHspICvqjzqAYIvj4yEblyNZUORfgf8J1UBvqqa6g+i7WWYks+KCzMMmIKt9PS8Hg2Z+ZkMmx4EQLbQjx9iOQJyZ+aOzlZgNxwlXJXW4Sf8yuvUv58MuNnhdytuN0Ehwcds=</Q><DP>e6v7fv+6nnBo1ezp1RyoWowuFoDkjF2wcc6xB+eU26tUZzAhBfVXbwYBSE5QAAei3H/n79bsNg4ttPz/gnpqfJdf/RF+Z5d99CU/VM0VwEYOnngqPMx+3kEiHWwGxOvp3dhPd/iaOryzrMS4ylznV1VmZSd73n97AG9wxfGk018=</DP><DQ>oZVunKwTdQY6EcZhOlh9bj9qK58sPG5k1mFODOdhVi9dj2aZzCvVPlAVBw8Ki2rwZKatByt97jgsInfjh36SCD9rVa1pVgQnBYpcxpHCdNQuJHEIJOH64Q7oi80dMnzshP7rry2PVtwo3JkmfTr6PlxZGSfYrXtZCWiito5Lw8U=</DQ><InverseQ>JvA3fAvkdAuLvxhG4hO5Cltaf0YilW2GcizC6geey8n9J1MOSvzt3bpr5r6NA3T7AhpqpcXiAqrHc0ZrkZGiKgVcGlK0WYT5iEqyblpIMw9e0xAdZlopfV2fFdN4rdu9zow/Zc0CWKtuhLaQfviGhU7KSq3LOhWxGD9UnAWCC8A=</InverseQ><D>h/on2atq7KptTqE+RQLc414lmVSbXSYZH8+E4sT/zdXHVbCXXBZ7CiSZ2m94r6+vUxDoEr8h4Z8bRdG366HrsxAfJujnsYtzh+r969HDRdGKrYcfbQOp7xo6lUhpYipTkY3Gs8htDyHxvsWbr52vG1dLGBtGrSvqLtkjetYCP6n1Tmkbi7quL6yZf2aaul2oQztiO1OqVqh6GIjHw98eQZ1vqq+gJfxIYS2Pjrb5S7rXnLyzIxDf2fWgPvokkEjChGqVvP/khJeW1H1JP9VAa71uMPbsZ8CEYWrQf9h1HQZwVjs2/qYIog5+rQhbF0slmr0w+H+YdNOLjdJRnJ26MQ==";
        int bitStrength = 2048;
//        RSACryptoServiceProvider rsaCryptoServiceProvider  = new RSACryptoServiceProvider(bitStrength);
//        rsaCryptoServiceProvider.FromXmlString(key);

        // 对私钥解密  // 获得私钥
        byte[] privateKeyBytes = Base64.decodeBase64(key.getBytes());
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory factory = KeyFactory.getInstance(KEY_RSA);
        PrivateKey privateKey = factory.generatePrivate(keySpec);

        Cipher cipher = Cipher.getInstance("RSA");//Cipher.getInstance("RSA/ECB/PKCS1Padding");
        PrivateKey privateKey1 = getPrivateKey1(key);
        cipher.init(Cipher.DECRYPT_MODE, privateKey1);
        byte[] deBytes = cipher.doFinal(encryString.getBytes());
        String s = new String(deBytes);
        System.out.println(s);
        int base64BlockSize = ((bitStrength / 8) % 3 != 0) ? (((bitStrength / 8) / 3) * 4) + 4 : ((bitStrength / 8) / 3) * 4;
        int iterations = encryString.length() / base64BlockSize;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iterations; i++) {

//            byte[] encryptedBytes = Convert.FromBase64String(encryString.substring(base64BlockSize * i, base64BlockSize));
            byte[] encryptedBytes = Base64.decodeBase64(encryString.substring(base64BlockSize * i, base64BlockSize + 1));

//            Array.Reverse(encryptedBytes);
            ArrayUtils.reverse(encryptedBytes);

//            arrayList.AddRange(rsaCryptoServiceProvider.Decrypt(encryptedBytes, true));
            // 返回UTF-8编码的解密信息
            int inputLen = encryptedBytes.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int j = 0;
            // 对数据分段解密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                    cache = cipher.doFinal(encryptedBytes, offSet, MAX_DECRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(encryptedBytes, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                j++;
                offSet = j * MAX_DECRYPT_BLOCK;
            }
            byte[] decryptedData = out.toByteArray();
            out.close();

            return new String(decryptedData, "UTF-8");


        }
//        outString = Encoding.UTF8.GetString(arrayList.ToArray(Type.GetType("System.Byte")) as byte[]);
        return null;
    }
    public static PrivateKey getPrivateKey1(String key) throws Exception {
//        byte[] keyBytes = (new BASE64Decoder()).decodeBuffer(key);
        byte[] keyBytes = Base64.decodeBase64(key.getBytes());

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    public static String realDecrypt(String inputString,String key) throws Exception {
        String outString = null;
        int bitStrength = 2048;
//      RSACryptoServiceProvider rsaCryptoServiceProvider = newRSACryptoServiceProvider(bitStrength);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(key.getBytes()));
//        rsaCryptoServiceProvider.FromXmlString(key);
        int base64BlockSize = ((bitStrength / 8) % 3 != 0) ? (((bitStrength / 8) / 3) * 4) + 4 : ((bitStrength / 8) / 3) * 4;
        int iterations = inputString.length() / base64BlockSize;
        ArrayList arrayList = newArrayList();
        for (int i = 0; i < iterations; i++) {
            //截取字符并decode
//            byte[] encryptedBytes = Convert.FromBase64String(inputString.Substring(base64BlockSize * i, base64BlockSize));
            byte[] encryptedBytes =  Base64.decodeBase64(inputString.substring(base64BlockSize * i, ((base64BlockSize * i) + base64BlockSize)));
            //反转字符
//            Array.Reverse(encryptedBytes);
            ArrayUtils.reverse(encryptedBytes);
            //解密字符结果并加入list
//            arrayList.AddRange(rsaCryptoServiceProvider.Decrypt(encryptedBytes, true));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
//          Cipher  cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-256ANDMGF1PADDING");
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPPadding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] pt = cipher.doFinal(encryptedBytes);
            System.out.println(new String(pt, StandardCharsets.UTF_8));
//            arrayList.add(result);
        }
        //在转String
        Object[] objects = arrayList.toArray();
        return "";
    }

}
