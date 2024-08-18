/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_twit_roy_moises;

//  sirve para la revision que gestione la lista de usuarios
// esta clase se encargará de almacenar y verificar los nombres de usuario y la constrasena.
/**
 *
 * @author royum
 */
public class UsuarioManager {

    private static final int MAX_USUARIOS = 1000;
    private static String[] usernames = new String[MAX_USUARIOS];
    private static String[] passwords = new String[MAX_USUARIOS];
    private static int contador = 0;

    // Agrega un nuevo usuario con una contraseña y las guarda
    public static boolean agregarUsuario(String username, String password) {
        if (contador >= MAX_USUARIOS) {
            return false; // No hay espacio para más usuarios
        }
        for (int exis = 0; exis < contador; exis++) {
            if (usernames[exis] != null && usernames[exis].equals(username)) {
                return false; // El usuario ya existe
            }
        }
        usernames[contador] = username;
        passwords[contador] = password; // Guardar la contraseña
        contador++;
        return true;
    }

    // Verifica si el nombre de usuario existe
    public static boolean usuarioExiste(String username) {
        for (int no = 0; no < contador; no++) {
            if (usernames[no] != null && usernames[no].equals(username)) {
                return true; // El usuario existe
            }
        }
        return false; // El usuario no existe
    }

    // Verifica si el nombre de usuario y la contraseña coinciden
    public static boolean autenticar(String username, String password) {
        for (int au = 0; au < contador; au++) {
            if (usernames[au] != null && usernames[au].equals(username) && passwords[au] != null && passwords[au].equals(password)) {
                return true; // Autenticacion exitosa
            }
        }
        return false; // Autenticacion fallida
    }
}
