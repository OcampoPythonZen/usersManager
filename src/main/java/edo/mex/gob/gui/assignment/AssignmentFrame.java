package edo.mex.gob.gui.assignment;

import edo.mex.gob.gui.menu.MenuGUI;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AssignmentFrame extends JFrame {

    String getCoursesQuery = "select course_name from course;";
    String getFilterUsersQuery =
            "select id_user, first_name, second_first_name, last_name, second_last_name, phone, email from public.user;";


    String[] usersColumnsNames =
            {"Id", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Telefono", "Correo Electronico"};
    String[] coursesColumnsNames =
            {"Id", "Nombre del Curso", "Fecha de Inicio", "Fecha de Termino", "Hora de Inicio", "Hora de termino", "Lugar", "Info"};


    AssignmentFrameLogic logic = new AssignmentFrameLogic();

    public AssignmentFrame() {
        initComponents();
        String title = "Asignación Usuarios/Cursos - Tlalnepantla Estado de Mexico";
        setTitle(title);
        setVisible(true);
    }

    private void initComponents() {

        JLabel jLabel1 = new JLabel();
        JTextField jTextField1 = new JTextField(16);
        JScrollPane jScrollPane1 = new JScrollPane();
        JTable jTable1 = new JTable();
        JScrollPane jScrollPane2 = new JScrollPane();
        JTable jTable2 = new JTable();
        JButton addUser = new JButton();
        JButton deleteUser = new JButton();
        JLabel jLabel2 = new JLabel();
        JComboBox<String> coursesBox = new JComboBox<>();
        JScrollPane jScrollPane3 = new JScrollPane();
        JTable jTable3 = new JTable();
        JButton addCourse = new JButton();
        JButton deleteCourse = new JButton();
        JButton saveBtn = new JButton();
        JButton sentEmailBtn = new JButton();
        JButton closeBtn = new JButton();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jLabel1.setText("Usuario:");


        jTable1.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "ID", "Nombre(s)", "Apellido Paterno", "Apellido Materno", "Correo Electrónico"
                }
        ) {
            final boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "ID", "Nombre(s)", "Apellido Paterno", "Apellido Materno", "Correo Electrónico"
                }
        ) {
            final boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        logic.getCourses(getCoursesQuery, coursesBox);


        jScrollPane2.setViewportView(jTable2);

        addUser.setText("Agregar");
        addUser.addActionListener(e -> {

        });

        deleteUser.setText("Eliminar");
        deleteUser.addActionListener(e -> {

        });

        jLabel2.setText("Selecciona el Curso:");

        jTable3.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "ID", "Nombre del Curso", "Horario", "Lugar", "Info"
                }
        ) {
            final boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        jScrollPane3.setViewportView(jTable3);

        addCourse.setText("Agregar");
        addCourse.addActionListener(e -> {

        });

        deleteCourse.setText("Eliminar");
        deleteCourse.addActionListener(e -> {
        });

        saveBtn.setText("Guardar");
        saveBtn.addActionListener(e -> {
        });

        sentEmailBtn.setText("Enviar Email");
        sentEmailBtn.addActionListener(e -> {
        });

        closeBtn.setText("Salir");
        closeBtn.addActionListener(e -> {
            this.dispose();
            new MenuGUI().setVisible(true);
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(
                                                                                jScrollPane3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE
                                                                        )
                                                                        .addGroup(layout.createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                                        false
                                                                                )
                                                                                .addComponent(jScrollPane2)
                                                                                .addComponent(jScrollPane1)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false
                                                                        )
                                                                        .addComponent(
                                                                                addCourse,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE
                                                                        )
                                                                        .addComponent(
                                                                                deleteUser,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE
                                                                        )
                                                                        .addComponent(
                                                                                addUser,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE
                                                                        )
                                                                        .addComponent(
                                                                                deleteCourse,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE
                                                                        )))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(24, 24, 24)
                                                                .addComponent(jLabel1)
                                                                .addGap(88, 88, 88)
                                                                .addComponent(
                                                                        jTextField1,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE
                                                                ))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(12, 12, 12)
                                                                .addComponent(jLabel2)
                                                                .addGap(45, 45, 45)
                                                                .addComponent(
                                                                        coursesBox,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE
                                                                ))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(98, 98, 98)
                                                .addComponent(saveBtn)
                                                .addGap(77, 77, 77)
                                                .addComponent(sentEmailBtn)
                                                .addGap(70, 70, 70)
                                                .addComponent(closeBtn)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(78, 78, 78)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(
                                                                jTextField1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE
                                                        ))
                                                .addGap(18, 18, 18)
                                                .addComponent(
                                                        jScrollPane1,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        91,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE
                                                )
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE
                                                )
                                                .addComponent(
                                                        jScrollPane2,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        92,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE
                                                )
                                                .addGap(51, 51, 51))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(189, 189, 189)
                                                .addComponent(addUser)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(deleteUser)
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE
                                                )))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(
                                                coursesBox,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE
                                        ))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(
                                                jScrollPane3,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                90,
                                                javax.swing.GroupLayout.PREFERRED_SIZE
                                        )
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(addCourse)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(deleteCourse)))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(saveBtn)
                                        .addComponent(sentEmailBtn)
                                        .addComponent(closeBtn))
                                .addGap(35, 35, 35))
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width - dialogSize.width) / 2, (screenSize.height - dialogSize.height) / 2);
    }

}
