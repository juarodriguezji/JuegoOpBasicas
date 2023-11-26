package com.example.alvaroflashcards;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.Scanner;

public class testingvoid extends AppCompatActivity  {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        long tiempoInicio = System.currentTimeMillis();
        long tiempoLimite = tiempoInicio + 60 * 1000;  // 1 minuto en milisegundos

        int respuestasCorrectas = 0;

        while (System.currentTimeMillis() < tiempoLimite) {
            // Generar dos números aleatorios de 0 a 9
            int numero1 = random.nextInt(10);
            int numero2 = random.nextInt(10);

            // Calcular la suma correcta
            int sumaCorrecta = numero1 + numero2;

            // Mostrar la pregunta al usuario
            System.out.println("¿Cuánto es " + numero1 + " + " + numero2 + "?");

            // Obtener la respuesta del usuario
            int respuestaUsuario = scanner.nextInt();

            // Verificar la respuesta
            if (respuestaUsuario == sumaCorrecta) {
                System.out.println("¡Correcto!\n");
                respuestasCorrectas++;
            } else {
                System.out.println("Incorrecto. La respuesta correcta era " + sumaCorrecta + "\n");
            }
        }

        System.out.println("Tiempo agotado. Respuestas correctas: " + respuestasCorrectas);

        // Cerrar el scanner
        scanner.close();
    }
}