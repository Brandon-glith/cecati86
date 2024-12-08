package net.javaguides.springboot.ApplicationLayer;

public class RequiredDocuments {

    public static String getNameDocument(Integer index) {

        String fileNames[] = {
                "Copia_de_Acta_de_Nacimiento",
                "Copia_de_CURP_(Clave_Única_de_Registro_de_Población)",
                "Copia_de_credencial_de_INE",
                "Copia_de_comprobante_de_último_grado_de_estudios",
                "Copia_de_comprobante_de_domicilio",
                "2_fotografías_tamaño_infantil",
                "2_copias_del_comprobante_de_pago"
        };

        return fileNames[index];
    }
}
