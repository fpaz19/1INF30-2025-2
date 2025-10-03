using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgDBManager
{
    public class Encriptamiento
    {
        public string GenerarClave()
        {
            Aes aes = Aes.Create();
            aes.KeySize = 128;
            aes.GenerateKey();
            return Convert.ToBase64String(aes.Key);
        }

        public static string Encriptar(string password, string clave)
        {
            byte[] temp = Convert.FromBase64String(clave);

            Aes aes = Aes.Create();
            aes.Key = temp;
            aes.Mode = CipherMode.ECB;
            aes.Padding = PaddingMode.PKCS7;

            var encriptador = aes.CreateEncryptor();
            byte[] bytesTexto = Encoding.UTF8.GetBytes(password);
            byte[] bytesEncriptado = encriptador.TransformFinalBlock(bytesTexto, 0, bytesTexto.Length);
            return Convert.ToBase64String(bytesEncriptado);
        }

        public static string Desencriptar(string password, string clave)
        {
            byte[] temp = Convert.FromBase64String(clave);
            Aes aes = Aes.Create();
            aes.Key = temp;
            aes.Mode = CipherMode.ECB;
            aes.Padding = PaddingMode.PKCS7;

            var desencriptador = aes.CreateDecryptor();
            byte[] bytesEncriptados = Convert.FromBase64String(password);
            byte[] bytesPlano = desencriptador.TransformFinalBlock(bytesEncriptados, 0, bytesEncriptados.Length);
            return Encoding.UTF8.GetString(bytesPlano);


        }
    }
}
