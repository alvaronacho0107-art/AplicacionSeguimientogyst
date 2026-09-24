# Firebase Analytics

La aplicación registra el evento recomendado `login` con `method = local` cuando
se validan correctamente las credenciales en LoginActivity, tanto desde el botón
Ingresar como desde el teclado. No registra credenciales ni datos personales.
Un intento incorrecto no genera este evento. Esto no agrega Firebase Authentication:
la validación de acceso sigue siendo local.

## Conectar el proyecto

1. En la consola de Firebase, crea o selecciona tu proyecto y habilita Google Analytics.
2. Registra una aplicación Android con el nombre de paquete exacto:
   `com.alvaro.seguimientodegarantiasyserviciostecnicos`.
3. Descarga su archivo real `google-services.json` y colócalo en `app/google-services.json`.
   El archivo ya está incluido y su paquete coincide con el de la aplicación.
4. Sincroniza Gradle en Android Studio y ejecuta la aplicación con acceso a Internet.

Se usa Firebase BoM 32.7.4 (Analytics 21.5.1) para mantener la configuración existente
de Kotlin 1.9.0 y compileSdk 34. No se necesitan módulos `-ktx` para esta integración.

## Comprobar el evento

Con un dispositivo o emulador conectado, ejecuta desde Android SDK Platform Tools:

```sh
adb shell setprop debug.firebase.analytics.app com.alvaro.seguimientodegarantiasyserviciostecnicos
```

Abre Firebase Console → Analytics → DebugView. Abre la app e inicia sesión con
`admin` / `1234`. Comprueba que aparece `login` y que contiene `method = local`.
Un acceso fallido no debe registrar `login`. Prueba también el envío desde el teclado.

Para desactivar el modo de depuración:

```sh
adb shell setprop debug.firebase.analytics.app .none.
```

## Documentación

- https://firebase.google.com/docs/android/setup
- https://firebase.google.com/docs/analytics/android/events
- https://firebase.google.com/docs/analytics/debugview
