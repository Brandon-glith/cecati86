document.addEventListener("DOMContentLoaded", function () {
    setTimeout(function () {
        // Oculta cada mensaje individual por su id
        document.getElementById('error-birthdate')?.style.display = 'none';
        document.getElementById('error-names')?.style.display = 'none';
        document.getElementById('error-email')?.style.display = 'none';
    }, 5000); // Tiempo en milisegundos (5000 ms = 5 segundos)
});
