package jogodavelha;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author iivnn
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    
    Board tela = new Board(true);
    Info info =  new Info(tela.getValue());
    int[] v = new int[2];
   
    
    
    public void updateBoard(){
        casa0.setText(integerToXO(this.tela.getBoard()[0][0]));
        casa1.setText(integerToXO(this.tela.getBoard()[0][1]));
        casa2.setText(integerToXO(this.tela.getBoard()[0][2]));
        casa3.setText(integerToXO(this.tela.getBoard()[1][0]));
        casa4.setText(integerToXO(this.tela.getBoard()[1][1]));
        casa5.setText(integerToXO(this.tela.getBoard()[1][2]));
        casa6.setText(integerToXO(this.tela.getBoard()[2][0]));
        casa7.setText(integerToXO(this.tela.getBoard()[2][1]));
        casa8.setText(integerToXO(this.tela.getBoard()[2][2]));
        losesn.setText(Integer.toString(this.info.getLoses()));
        winsn.setText(Integer.toString(this.info.getWins()));
        tiesn.setText(Integer.toString(this.info.getTies()));
        texto.setText(this.info.getInfo());
    }
    public String integerToXO(int num){
        if(num==0){
            return " ";
        }else if(num==-1){
            return "O";
        }else{
            return "X";
        }
    }
    public void updateWinner(){
        if(this.tela.findWinner()== 2){
            JOptionPane.showMessageDialog(null,"O jogo deu Velha");
            this.tela.reset();
            this.info.setTies(info.getTies() + 1);
            this.info.setInfo(info.getInfo() + "O " + (info.getTies()+info.getLoses()
            +info.getWins()) + "º jogo empatou.\n");
            updateBoard();
            
        }else if(this.tela.findWinner()==-1){
            if(this.info.getPlayerValue() == -1){
                changeToRed();
                updateBoard();
                this.info.setWins(info.getWins() + 1);
                JOptionPane.showMessageDialog(null,"Você venceu!");
                this.info.setInfo(info.getInfo() + "O " + (info.getTies()+info.getLoses()
                +info.getWins()) + "º resultou em vitória sua.\n");    
                this.tela.reset();
            }else{
                changeToRed();
                updateBoard();
                this.info.setLoses(info.getLoses() + 1);
                JOptionPane.showMessageDialog(null,"Você perdeu!");
                this.info.setInfo(info.getInfo() + "O " + (info.getTies()+info.getLoses()
                +info.getWins()) + "º resultou em vitória do bot.\n");
                this.tela.reset();    
            }
            updateBoard();            
        }else if(this.tela.findWinner()== 1){
            if(this.info.getPlayerValue() == 1){
                changeToRed();
                updateBoard();
                this.info.setWins(info.getWins() + 1);
                JOptionPane.showMessageDialog(null,"Você venceu!");
                this.info.setInfo(info.getInfo() + "O " + (info.getTies()+info.getLoses()
                +info.getWins()) + "º resultou em vitória sua.\n");
                this.tela.reset();
            }else{
                changeToRed();
                updateBoard();
                this.info.setLoses(info.getLoses() + 1);
                JOptionPane.showMessageDialog(null,"Você perdeu!");
                this.info.setInfo(info.getInfo() + "O " + (info.getTies()+info.getLoses()
                +info.getWins()) + "º resultou em vitória do bot.\n");
                this.tela.reset();
            }
        }
        changeToBlack();
        updateBoard();
    }
    
    
    public void botTurn(){
        if(this.tela.getRounds() != 9){
            v = BoardBot.boardBotMove(tela);
            this.tela.move(v[0], v[1]);
        }
    }
    
    
    public void changeToRed(){
        int num = -1;
        for(int x=0;x<8;x++){
            if(this.tela.getSum()[x] == 3 || this.tela.getSum()[x] == -3){
                num = x;
                break;
            }
        }
        
        switch (num){
            case 0:
                casa0.setForeground(Color.red);
                casa1.setForeground(Color.red);
                casa2.setForeground(Color.red);
                break;
            case 1:
                casa3.setForeground(Color.red);
                casa4.setForeground(Color.red);
                casa5.setForeground(Color.red);
                break;
            case 2:
                casa6.setForeground(Color.red);
                casa7.setForeground(Color.red);
                casa8.setForeground(Color.red);
                break;
            case 3:
                casa0.setForeground(Color.red);
                casa3.setForeground(Color.red);
                casa6.setForeground(Color.red);
                break;
            case 4:
                casa1.setForeground(Color.red);
                casa4.setForeground(Color.red);
                casa7.setForeground(Color.red);
                break;
            case 5:
                casa2.setForeground(Color.red);
                casa5.setForeground(Color.red);
                casa8.setForeground(Color.red);
                break;
            case 6:
                casa0.setForeground(Color.red);
                casa4.setForeground(Color.red);
                casa8.setForeground(Color.red);
                break;
            case 7:
                casa2.setForeground(Color.red);
                casa4.setForeground(Color.red);
                casa6.setForeground(Color.red);
                break;
        }
        
        
    }
    
    private void changeToBlack(){
        casa0.setForeground(Color.BLACK);
        casa1.setForeground(Color.BLACK);
        casa2.setForeground(Color.BLACK);
        casa3.setForeground(Color.BLACK);
        casa4.setForeground(Color.BLACK);
        casa5.setForeground(Color.BLACK);
        casa6.setForeground(Color.BLACK);
        casa7.setForeground(Color.BLACK);
        casa8.setForeground(Color.BLACK);    
    }
            
    
    
    
    
    
    public Main() {
        initComponents();
        updateBoard();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        casa0 = new javax.swing.JLabel();
        casa1 = new javax.swing.JLabel();
        casa2 = new javax.swing.JLabel();
        casa3 = new javax.swing.JLabel();
        casa4 = new javax.swing.JLabel();
        casa5 = new javax.swing.JLabel();
        casa6 = new javax.swing.JLabel();
        casa7 = new javax.swing.JLabel();
        casa8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextPane();
        losesn = new javax.swing.JLabel();
        wins = new javax.swing.JLabel();
        loses = new javax.swing.JLabel();
        ties = new javax.swing.JLabel();
        winsn = new javax.swing.JLabel();
        tiesn = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        resetToX = new javax.swing.JMenuItem();
        resetoToO = new javax.swing.JMenuItem();
        jSair = new javax.swing.JMenuItem();
        About = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo da velha");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        casa0.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        casa0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        casa0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                casa0MousePressed(evt);
            }
        });

        casa1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        casa1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        casa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                casa1MousePressed(evt);
            }
        });

        casa2.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        casa2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        casa2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                casa2MousePressed(evt);
            }
        });

        casa3.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        casa3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        casa3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                casa3MousePressed(evt);
            }
        });

        casa4.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        casa4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        casa4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                casa4MousePressed(evt);
            }
        });

        casa5.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        casa5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        casa5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                casa5MousePressed(evt);
            }
        });

        casa6.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        casa6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        casa6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                casa6MousePressed(evt);
            }
        });

        casa7.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        casa7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        casa7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                casa7MousePressed(evt);
            }
        });

        casa8.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        casa8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        casa8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                casa8MousePressed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(casa0, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(casa5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(casa1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(casa7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(casa2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(casa8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(casa4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(casa6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(casa3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(casa0, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(casa5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(casa1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(casa7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(casa2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(casa8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(casa4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(casa6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(casa3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 290, 260));

        jScrollPane1.setViewportView(texto);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 410, 480));

        losesn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        losesn.setText("0");
        getContentPane().add(losesn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 110, 40));

        wins.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        wins.setText("Vitórias:");
        getContentPane().add(wins, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 110, 40));

        loses.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        loses.setText("Derrotas:");
        getContentPane().add(loses, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 110, 40));

        ties.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ties.setText("Empates:");
        getContentPane().add(ties, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 110, 40));

        winsn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        winsn.setText("0");
        getContentPane().add(winsn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 110, 40));

        tiesn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tiesn.setText("0");
        getContentPane().add(tiesn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 110, 40));

        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuBar1.setMargin(new java.awt.Insets(1, 1, 1, 1));

        jMenu2.setText("Opções");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenu3.setText("Resetar");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        resetToX.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        resetToX.setText("para \"x\"");
        resetToX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetToXActionPerformed(evt);
            }
        });
        jMenu3.add(resetToX);

        resetoToO.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        resetoToO.setText("para \"o\"");
        resetoToO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetoToOActionPerformed(evt);
            }
        });
        jMenu3.add(resetoToO);

        jMenu2.add(jMenu3);

        jSair.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jSair.setText("Sair");
        jSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSairActionPerformed(evt);
            }
        });
        jMenu2.add(jSair);

        jMenuBar1.add(jMenu2);

        About.setText("Sobre");
        About.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        About.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                AboutComponentAdded(evt);
            }
        });
        About.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AboutMousePressed(evt);
            }
        });
        jMenuBar1.add(About);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void casa0MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_casa0MousePressed
        // TODO add your handling code here:
        if(tela.getBoard()[0][0] == 0){
            this.tela.move(0,0);
            this.tela.sumAll();
            updateWinner();
            updateBoard();
            botTurn();
            this.tela.sumAll();
            updateBoard();
            updateWinner(); 
        }    
    }//GEN-LAST:event_casa0MousePressed

    private void casa1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_casa1MousePressed
        // TODO add your handling code here:
        if(tela.getBoard()[0][1] == 0){
            this.tela.move(0,1);
            this.tela.sumAll();
            updateBoard();
            updateWinner();
            botTurn();
            this.tela.sumAll();
            updateBoard();
            updateWinner();  
        }  
    }//GEN-LAST:event_casa1MousePressed

    private void casa2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_casa2MousePressed
        // TODO add your handling code here:
        if(tela.getBoard()[0][2] == 0){
            this.tela.move(0,2);
            this.tela.sumAll();
            updateWinner();
            botTurn();
            this.tela.sumAll();
            updateBoard();
            updateWinner();  
        }   
    }//GEN-LAST:event_casa2MousePressed

    private void casa3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_casa3MousePressed
        // TODO add your handling code here:
        if(tela.getBoard()[1][0] == 0){
            this.tela.move(1,0);
            this.tela.sumAll();
            updateWinner();
            updateBoard();
            botTurn();
            this.tela.sumAll();
            updateBoard();
            updateWinner();  
        }
    }//GEN-LAST:event_casa3MousePressed

    private void casa4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_casa4MousePressed
        // TODO add your handling code here:
        if(tela.getBoard()[1][1] == 0){
            this.tela.move(1,1);
            this.tela.sumAll();
            updateWinner();
            updateBoard();
            botTurn();
            this.tela.sumAll();
            updateBoard();
            updateWinner(); 
        }    
    }//GEN-LAST:event_casa4MousePressed

    private void casa5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_casa5MousePressed
        // TODO add your handling code here:
        if(tela.getBoard()[1][2] == 0){
            this.tela.move(1,2);
            this.tela.sumAll();
            updateWinner();
            updateBoard();
            botTurn();
            this.tela.sumAll();
            updateBoard();
            updateWinner();  
        }
    }//GEN-LAST:event_casa5MousePressed

    private void casa6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_casa6MousePressed
        // TODO add your handling code here:
        if(tela.getBoard()[2][0] == 0){
            this.tela.move(2,0);
            this.tela.sumAll();
            updateWinner();
            updateBoard();
            botTurn();
            this.tela.sumAll();
            updateBoard();
            updateWinner(); 
        }
    }//GEN-LAST:event_casa6MousePressed

    private void casa7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_casa7MousePressed
        // TODO add your handling code here:
        if(tela.getBoard()[2][1] == 0){
            this.tela.move(2,1);
            this.tela.sumAll();
            updateWinner();
            updateBoard();
            botTurn();
            this.tela.sumAll();
            updateBoard();
            updateWinner(); 
        }
    }//GEN-LAST:event_casa7MousePressed

    private void casa8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_casa8MousePressed
        // TODO add your handling code here:
        if(tela.getBoard()[2][2] == 0){
            this.tela.move(2,2);
            this.tela.sumAll();
            updateWinner();
            updateBoard();
            botTurn();
            this.tela.sumAll();
            updateBoard();
            updateWinner();  
        } 
    }//GEN-LAST:event_casa8MousePressed

    private void resetToXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetToXActionPerformed
        // TODO add your handling code here:
        this.tela = new Board(true);
        this.info.reset(tela.getValue());
        this.info.setInfo(info.getInfo() + "Você mudou para 'X'\n");
        this.info.setInfo(info.getInfo() + "Jogo resetado.\n");
        this.v = new int[2];
        updateBoard();
        
    }//GEN-LAST:event_resetToXActionPerformed

    private void resetoToOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetoToOActionPerformed
        // TODO add your handling code here:
        this.tela = new Board(false);
        this.info.reset(tela.getValue());
        this.info.setInfo(info.getInfo() + "Você mudou para 'O'\n");
        this.info.setInfo(info.getInfo() + "Jogo resetado.\n");
        this.v = new int[2];
        updateBoard();
    }//GEN-LAST:event_resetoToOActionPerformed

    private void jSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jSairActionPerformed

    private void AboutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AboutMousePressed
        // TODO add your handling code here:
        String msg = "Este projeto é um jogo da velha simples, ele foi feito com\n"
                + " a IDE netbeans, linguagem java e para interface gráfica\n "
                + "utilizo o pacote swing. Neste projeto busco aplicar meus\n "
                + "conhecimentos em algoritmo, matriz e orientação a objeto\n.A "
                + "interface gráfica será simples pois esse não é o meu foco.\n";
        JOptionPane.showMessageDialog(null, msg, "Sobre", WIDTH);
    }//GEN-LAST:event_AboutMousePressed

    private void AboutComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_AboutComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_AboutComponentAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Main().setVisible(true);
               
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu About;
    private javax.swing.JLabel casa0;
    private javax.swing.JLabel casa1;
    private javax.swing.JLabel casa2;
    private javax.swing.JLabel casa3;
    private javax.swing.JLabel casa4;
    private javax.swing.JLabel casa5;
    private javax.swing.JLabel casa6;
    private javax.swing.JLabel casa7;
    private javax.swing.JLabel casa8;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem jSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel loses;
    private javax.swing.JLabel losesn;
    private javax.swing.JMenuItem resetToX;
    private javax.swing.JMenuItem resetoToO;
    private javax.swing.JTextPane texto;
    private javax.swing.JLabel ties;
    private javax.swing.JLabel tiesn;
    private javax.swing.JLabel wins;
    private javax.swing.JLabel winsn;
    // End of variables declaration//GEN-END:variables
}
