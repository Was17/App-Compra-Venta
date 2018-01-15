# App-Compra-Venta
App para la Asignatura Laboratorio de discpositivos moviles de la URJC
 
 [APK DOWNLOAD(BETA VERSION)](https://drive.google.com/open?id=1VoCwylB85xRevmN5coeOU77_4tMve3rt)
 
 //En edicción
 
Nuestra aplicacion se basa en una aplicacion de compra y venta sin pago a traves de la app, cuya funcion principal es poner en contacto al comprador y vendedor.
Consta por tanto de las siguientes funciones:

    Control de Usuarios
    Adicion de anuncios
    Base de datos local
    Vista de productos de interes del usuario
    Vista perfil de usuario
    Contacto a traves de email
    
Esta apliacion usa los siguientes permisos del sistema

    Acceso a camara
    Lectura de memoria
    Escritura de memoria 
    Internet

##Pantallas
###Activities
######MainActivity  
Splash Screen.
######WelcomeActivity
 Actividad que nos presenta la aplicacion. Tiene la funcionalidad de redireccionar a la pagina de loginActivty o MenuActivity, segun si estamos logeados o no.

 ![Vista de las pantallas de informacion](readmeFiles/WelcomeActivity.jpg)

LoginActivty
Ventana con los dialogos para iniciar la sesion
 ![Vista de pantalla login](readmeFiles/Screenshot_1516026501.png)
 

MenuActivity
ProfileActivity
ArticuloActivity
AddArticuloActivity
ChangePasswordActivity
ChangeEmailActivity
###Fragments
UserFragment
CompraFragment
VentaFragment
InteresFragment
###Utils
Database
BitMapDatabase
PrefManager
SessionManager
###Class
Articulo
User