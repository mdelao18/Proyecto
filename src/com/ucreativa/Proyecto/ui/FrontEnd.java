package com.ucreativa.Proyecto.ui;

import com.ucreativa.Proyecto.repositories.FileRepository;
import com.ucreativa.Proyecto.services.PlataformaServices;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FrontEnd extends JFrame {

    public FrontEnd(String titulo) {
        super(titulo);
    }

    public void build() {
        this.construccionPantalla();
        this.crearComponentes();
        super.setVisible(true);
    }

    public void construccionPantalla() {
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(500, 300);
        super.setLayout(new GridLayout(5, 2));
    }

    private void agregarComponentes(Component componente) {
        super.getContentPane().add(componente);
    }

    private void crearComponentes() {
        //Crear Labels
        JLabel lblNombre = new JLabel("Nombre: ");
        JLabel lblId = new JLabel("ID: ");
        JLabel lblGenero = new JLabel("Genero: ");
        JLabel lblPeriodo = new JLabel("Año: ");
        JLabel lblIsPelicula = new JLabel("Es una pelicula? ");
        JLabel lblDuracion = new JLabel("Duración (en horas): ");
        JLabel lblNumTemporadas = new JLabel("Temporadas: ");
        JLabel lblNumEpisodios = new JLabel("Episodios: ");
        JLabel lblPlataforma = new JLabel("Plataforma: ");

        //Crear textos
        JTextField txtNombre = new JTextField();
        JTextField txtId = new JTextField();
        JTextField txtGenero = new JTextField();
        JTextField txtPeriodo = new JTextField();
        JTextField txtDuracion = new JTextField();
        JTextField txtNumTemporadas = new JTextField();
        JTextField txtNumEpisodios = new JTextField();
        JTextField txtPlataforma = new JTextField();
        JCheckBox txtisPelicula = new JCheckBox();


        txtisPelicula.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblDuracion.setVisible(txtisPelicula.isSelected());
                txtDuracion.setVisible(txtisPelicula.isSelected());
                lblNumTemporadas.setVisible(!txtisPelicula.isSelected());
                txtNumTemporadas.setVisible(!txtisPelicula.isSelected());
                lblNumEpisodios.setVisible(!txtisPelicula.isSelected());
                txtNumEpisodios.setVisible(!txtisPelicula.isSelected());
            }
        });

        JButton guardar = new JButton("Guardar");
        guardar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlataformaServices service = new PlataformaServices(new FileRepository());
                try {
                    service.agregarProyeccion(
                            txtNombre.getText(),
                            txtId.getText(),
                            txtGenero.getText(),
                            txtPeriodo.getText(),
                            txtisPelicula.isSelected(),
                            txtNumEpisodios.getText(),
                            txtNumTemporadas.getText(),
                            txtDuracion.getText(),
                            txtPlataforma.getText());

                    txtNombre.setText("");
                    txtId.setText("");
                    txtGenero.setText("");
                    txtPeriodo.setText("");
                    txtisPelicula.setText("");
                    txtNumEpisodios.setText("");
                    txtNumTemporadas.setText("");
                    txtDuracion.setText("");
                    txtPlataforma.setText("");

                    String reporte = String.join("\n", service.get());
                    JOptionPane.showMessageDialog(((JButton) e.getSource()).getParent(), reporte);

                } catch (Exception error) {
                    JOptionPane.showMessageDialog(((JButton) e.getSource()).getParent(), error.getMessage());
                }
            }
        });

        //Agregamos al UI
        this.agregarComponentes(lblNombre);
        this.agregarComponentes(txtNombre);
        this.agregarComponentes(lblId);
        this.agregarComponentes(txtId);
        this.agregarComponentes(lblGenero);
        this.agregarComponentes(txtGenero);
        this.agregarComponentes(lblPeriodo);
        this.agregarComponentes(txtPeriodo);
        this.agregarComponentes(lblIsPelicula);
        this.agregarComponentes(txtisPelicula);
        this.agregarComponentes(lblNumEpisodios);
        this.agregarComponentes(txtNumEpisodios);
        this.agregarComponentes(lblNumTemporadas);
        this.agregarComponentes(txtNumTemporadas);
        this.agregarComponentes(lblDuracion);
        this.agregarComponentes(txtDuracion);
        this.agregarComponentes(lblPlataforma);
        this.agregarComponentes(txtPlataforma);
        this.agregarComponentes(guardar);
    }
}
