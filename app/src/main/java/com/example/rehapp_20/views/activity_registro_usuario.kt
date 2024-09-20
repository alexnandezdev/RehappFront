package com.example.rehapp_20.views

// Importaciones necesarias para la funcionalidad de la actividad
import android.content.Intent  // Permite navegar entre actividades
import android.os.Bundle  // Para manejar el ciclo de vida de la actividad
import android.util.Log  // Para logs y depuración
import android.widget.Button  // Interactuar con botones de la interfaz
import android.widget.EditText  // Interactuar con campos de texto
import android.widget.Toast  // Mostrar mensajes breves al usuario
import androidx.activity.viewModels  // Obtener instancias de ViewModels
import androidx.appcompat.app.AppCompatActivity  // Actividad base para compatibilidad
import androidx.lifecycle.Observer  // Para observar LiveData
import com.example.rehapp_20.R  // Referencias a los recursos
import com.example.rehapp_20.enums.UserType  // Enum para definir el tipo de usuario
import com.example.rehapp_20.models.PatientUserRegisterDTO  // DTO para el registro del paciente
import com.example.rehapp_20.registro_exitoso_Fisio  // Actividad para mostrar registro exitoso
import com.example.rehapp_20.viewmodels.UserViewModel  // ViewModel para manejar lógica de usuario
import dagger.hilt.android.AndroidEntryPoint  // Hilt para inyección de dependencias

// Anotación para permitir la inyección de dependencias con Hilt
@AndroidEntryPoint
class activity_registro_usuario : AppCompatActivity() {

    // Se inyecta el ViewModel que gestionará la lógica del registro de usuarios
    private val userViewModel: UserViewModel by viewModels()
    private val TAG = "activity_registro_usuario"  // Tag para los logs de esta clase

    // Método que se ejecuta cuando se crea la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Se establece el layout para esta actividad
        setContentView(R.layout.activity_registro_usuario)

        // Se obtiene el botón de registro del layout y se configura su listener
        val buttonRegistrarme: Button = findViewById(R.id.ButtonRegistroExitoso)
        buttonRegistrarme.setOnClickListener {
            // Se obtienen los valores de los campos de texto
            val email = findViewById<EditText>(R.id.textView_Correo_registro).text.toString()
            val password = findViewById<EditText>(R.id.textView_Contraseña_registro).text.toString()
            val confirmPassword = findViewById<EditText>(R.id.textView_Confirmacion_registro).text.toString()

            // Log para depuración cuando se hace clic en el botón de registro
            Log.d(TAG, "onCreate: Click en 'Registrarme' con email: $email")

            // Se verifica que los campos no estén vacíos y que las contraseñas coincidan
            if (email.isNotEmpty() && password.isNotEmpty() && password == confirmPassword) {
                // Si la validación es correcta, se crea el objeto DTO del usuario paciente
                val user = PatientUserRegisterDTO(
                    email = email,
                    userName = findViewById<EditText>(R.id.textView_Nombre_usuario).text.toString(),
                    password = password,
                    userType = UserType.PATIENT  // Se especifica que el tipo de usuario es paciente
                )
                // Log para depuración mostrando el DTO que se enviará
                Log.d(TAG, "onCreate: Enviando DTO para registro: $user")
                // Se llama al ViewModel para registrar al usuario
                userViewModel.registerUser(user)
            } else {
                // Si la validación falla, se muestra un mensaje y se genera un log de advertencia
                Log.w(TAG, "onCreate: Fallo en la validación del formulario")
                Toast.makeText(this, "Por favor, verifica los campos y asegúrate de que las contraseñas coincidan.", Toast.LENGTH_SHORT).show()
            }
        }

        // Se observa el resultado del registro usando LiveData del ViewModel
        userViewModel.registrationResult.observe(this, Observer { response ->
            if (response.isSuccessful) {
                // Si el registro fue exitoso, se muestra un mensaje y se navega a la actividad de éxito
                Log.d(TAG, "onCreate: Registro exitoso con respuesta: ${response.body()}")
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity_Registro_Exitoso::class.java)
                startActivity(intent)
            } else {
                // Si hubo un error en el registro, se muestra un mensaje de error y se loguea el fallo
                Log.e(TAG, "onCreate: Fallo en el registro con código: ${response.code()}, mensaje: ${response.message()}")
                Toast.makeText(this, "Fallo en el registro: ${response.message()}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

