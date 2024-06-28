import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;


public class Quiz implements ActionListener {
    
    String[] questions = { "Co jest stolica Niemiec?",//1
                            "Co jest stolica Norwegii?",//2
                            "Kto obecnie jest prezydentem Francji?",//3
                            "Jaka jest najwieksza rzeka w Polsce?",//4
                            "Ile bundeslandow maja Niemcy?",//5
                            "W jakim jezyku nie mowi sie w Szwajcarii?",//6
                            "Jakie jest najmniejsze panstwo w Europie?",//7
                            "Jaka walute uzywa sie w Japonii?",//8
                            "Co jest stolica Wloch?",//9 1-9 latwe
                            "Gdzie znajduje sie Sahara?",//10
                            "Ktore panstwo jest najwieksze pod wzgledem powierzchni w Afryce?",//11
                            "Jakie miasto jest stolica Kanady?",//12
                            "W ktorym kraju znajduje sie Machu Picchu?",//13
                            "Ktora wyspa jest najwieksza na swiecie?",//14
                            "Gdzie znajduje sie Wielki Bariery Koralowej?",//15
                            "Jak nazywa sie najwyzszy szczyt w Europie?",//16
                            "Ktory kraj jest znany jako 'Kraj Srodka'?",//17
                            "W jakim panstwie lezy Wielka Muralla?",//18
                            "Ktora rzeka przeplywa przez Paryz?",//19
                            "Gdzie znajduje sie wielki kanion?",//20 10-20 srednie
                            "Jakie miasto jest znane jako 'Wenecja Polnocy'?",//21
                            "Ktore morze jest najwieksze na Ziemi?",//22
                            "Gdzie lezy najzimniejszy staly obszar zamieszkaly na swiecie?",//23
                            "Ile mieszkancow liczy Tokio?",//24
                            "W jakim kraju mowi sie w jezyku ZULU?"//25 21-25 trudne
                        };
    //z indeksem i, 1 to poprawna
    String[][] options = {
                            {"Berlin", "Monachium", "Frankfurt", "Hamburg"},//1
                            {"Oslo", "Trondheim", "Bergen", "Stavanger"},//2
                            {"Emmanuel Macron", "Francois Hollande", "Nicolas Sarkozy", "Jacques Chirac"},//3
                            {"Wisla", "Odra", "Warta", "San"},//4
                            {"16", "15", "14", "17"},//5
                            {"Angielskim", "Niemieckim", "Francuskim", "Wloskim"},//6
                            {"Monako", "Malta", "San Marino", "Andora"},//7
                            {"Jen", "Juan", "Dolar Japonski", "Rupia"},//8
                            {"Rzym", "Mediolan", "Wenecja", "Florencja"},//9
                            {"Afryce Polnocnej", "Afryce Zachodniej", "Afryce Wschodniej", "Afryce Poludniowej"},//10
                            {"Algieria", "Kongo", "Sudan", "Nigeria"},//11
                            {"Toronto", "Vancouver", "Ottawa", "Montreal"},//12
                            {"Peru", "Boliwia", "Ekwador", "Kolumbia"},//13
                            {"Borneo", "Sumatra", "Wyspa Ellesmerea", "Wyspa Kerguelena"},//14
                            {"Morze Czerwone", "Morze Arabskie", "Morze Andamanskie", "Ocean Indyjski"},//15
                            {"Elbrus", "Mont Blanc", "Matterhorn", "Kilimandzaro"},//16
                            {"Chiny", "Indie", "Rosja", "Korea Poludniowa"},//17
                            {"Chiny", "Mongolia", "Indie", "Rosja"},//18
                            {"Tamiza", "Laba", "Ryga", "Sekwana"},//19
                            {"Kolorado", "Copper", "Grand", "Glacier"},//20
                            {"Amsterdam", "Kopenhaga", "Bruksela", "Hamburg"},//21
                            {"Pacyfik", "Atlantyk", "Indyjski", "Arktyczny"},//22
                            {"Arktyka", "Antarktyda", "Sahara", "Tajga"},//23
                            {"38 milionow", "125 milionow", "2 miliony", "90 milionow"},//24
                            {"Poludniowej Afryce", "Zambii", "Zimbabwe", "Botswanie"}//25
                        };
                        
                        
    public static void main(String[] args){
        Quiz quizik = new Quiz();
    }


    char guess;
    String answer;
    int index;
    int correctGuesses = 0;
    int LengthOfQuiz = 5;
    double result;
    int poprawny_indeks;
    private int timer = 15;
    private boolean isTimerClicked = false;

    Random random = new Random();
    int[] usedIndexes = new int[LengthOfQuiz]; // Tablica do przechowywania użytych indeksów
    int currentIndex = 0;
    JPanel centerPanel = new JPanel(new GridLayout(2, 2, 50, 50));
    //To do testów na razie 
    JFrame frame = new JFrame();
    JLabel textField = new JLabel();
    JLabel textarea = new JLabel();
    //Przyciski na odp
    JButton buttonA = new JButton();
    JButton buttonB = new JButton(); 
    JButton buttonC = new JButton(); 
    JButton buttonD = new JButton();  

    JLabel answerLabelA = new JLabel();
    JLabel answerLabelB = new JLabel();
    JLabel answerLabelC = new JLabel();
    JLabel answerLabelD = new JLabel();

    JLabel correctAns = new JLabel();
    JLabel corrPercentage = new JLabel();
    JPanel bottomPanel = new JPanel(new GridLayout(2, 1, 20, 20));
    JPanel menuPanel = new JPanel();
    JLabel MenuField = new JLabel();
    JLabel zegarField = new JLabel();
    Zegar zegar = new Zegar();

    JButton menuButton1 = new JButton();
    JButton menuButton2 = new JButton(); 
    JButton menuButton3 = new JButton(); 
    JButton menuButton4 = new JButton();  
    

    //wypelnianie metod
    public Quiz(){
        //do testowania metod
        JFrame frame = new JFrame("GeoLearner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 720);
        frame.getContentPane().setBackground(new Color(0x003BAE));
        frame.setLayout(new BorderLayout(5, 5));
        frame.setResizable(false);

        // Top Panel - TextField and TextArea
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 1));
        
        // TextField
        textField.setBackground(new Color(0x000C18));
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font("Arial", Font.BOLD, 30));
        textField.setHorizontalAlignment(JLabel.CENTER); 
        textField.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
        textField.setOpaque(true); 
        topPanel.add(textField, BorderLayout.CENTER);

        // TextArea
        textarea.setBackground(new Color(0x003BAE));
        textarea.setForeground(Color.WHITE);
        textarea.setFont(new Font("Arial", Font.BOLD, 30));
        textarea.setHorizontalAlignment(JLabel.CENTER); 
        textarea.setBorder(BorderFactory.createEmptyBorder(30, 20, 50, 20));
        textarea.setOpaque(true); 
       
        topPanel.add(textarea);

        frame.add(topPanel, BorderLayout.NORTH);

        // Center Panel - Buttons and Labels
        
        centerPanel.setBackground(new Color(0x003BAE));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 50, 20));
        // Buttons
        JButton[] buttons = {buttonA, buttonB, buttonC, buttonD};
        JLabel[] labels = {answerLabelA, answerLabelB, answerLabelC, answerLabelD};
        for (int i = 0; i < buttons.length; i++) {

            buttons[i].setFont(new Font("Arial", Font.BOLD, 25));
            buttons[i].addActionListener(this);
            buttons[i].setPreferredSize(new Dimension(150, 50));
            buttons[i].setBackground(new Color(0x000C18));
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setFocusable(false);
            buttons[i].setText(labels[i].getName());
            centerPanel.add(buttons[i]);

        }

         // Dodanie panelu menu z lewej strony
         menuPanel.setBackground(new Color(0x000C18));
         menuPanel.setBounds(0,0,50,200);
         menuPanel.setLayout(new GridLayout(6, 1));
         menuButton1 = new JButton("Home");
         menuButton2 = new JButton("Start Timer");
         menuButton3 = new JButton("Stop Timer");
         menuButton4 = new JButton("Reset Timer");
         
        menuButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               zegarField.setVisible(true);
               zegar.startCountdown(zegarField); 
               isTimerClicked = true;
            }
        });
        menuButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               zegar.stopCountdown();
               isTimerClicked = false;
            }
        });
        menuButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
              zegar.resetCountdown(zegarField);
              isTimerClicked = false;
            }
        });

        zegar.setCountdownListener(new CountdownListener() {
            @Override
            public void onCountdownFinish() {
                timer = zegar.getTime();
                zegar.resetCountdown(zegarField);
                nextQuestion();
            }
        });

        //Menu Text
        MenuField.setBackground(new Color(0x000C18));
        MenuField.setForeground(Color.WHITE);
        MenuField.setFont(new Font("Arial", Font.BOLD, 30));
        MenuField.setHorizontalAlignment(JLabel.CENTER); 
        MenuField.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
        MenuField.setOpaque(true);
        MenuField.setText("Menu");
        menuPanel.add(MenuField, BorderLayout.CENTER);

        //Timer
        zegarField.setBackground(new Color(0x000C18));
        zegarField.setForeground(Color.WHITE);
        zegarField.setFont(new Font("Arial", Font.BOLD, 30));
        zegarField.setHorizontalAlignment(JLabel.CENTER); 
        zegarField.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
        zegarField.setOpaque(true);
        zegarField.setText(timer + "");
        zegarField.setVisible(false);
        menuPanel.add(zegarField, BorderLayout.CENTER);
        

         JButton[] menuButtons = {menuButton1, menuButton2, menuButton3, menuButton4};
         for (JButton menuButton : menuButtons) {
             menuButton.setFont(new Font("Arial", Font.BOLD, 20));
             menuButton.setPreferredSize(new Dimension(150, 50));
             menuButton.setBackground(new Color(0x000C18));
             menuButton.setForeground(Color.WHITE);
             menuButton.setFocusable(false);
             menuButton.setEnabled(true);
             menuPanel.add(menuButton);
         }
         frame.add(menuPanel, BorderLayout.WEST);
        // Bottom Panel - Correct Answer and Percentage
        
        // Correct Answer Field
        correctAns.setHorizontalAlignment(JLabel.CENTER);
        correctAns.setBorder(BorderFactory.createBevelBorder(1));
        correctAns.setFont(new Font("Arial", Font.BOLD, 50));
        correctAns.setBackground(new Color(0x32C434));
        correctAns.setForeground(Color.WHITE);
        correctAns.setPreferredSize(new Dimension(200, 50));
        correctAns.setOpaque(true);
        bottomPanel.add(correctAns);
        bottomPanel.setBackground(new Color(0x003BAE));
        
        // Correct Percentage Field
        corrPercentage.setHorizontalAlignment(JLabel.CENTER);
        corrPercentage.setBorder(BorderFactory.createBevelBorder(1));
        corrPercentage.setBackground(new Color(0x000C18));
        corrPercentage.setForeground(Color.WHITE);
        corrPercentage.setFont(new Font("Arial", Font.BOLD, 30));
        corrPercentage.setPreferredSize(new Dimension(200, 50));
        corrPercentage.setOpaque(true);
        bottomPanel.add(corrPercentage);
        frame.add(bottomPanel, BorderLayout.CENTER);
        frame.add(centerPanel, BorderLayout.CENTER);
        bottomPanel.setVisible(false);

        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 100, 50, 100));
        
        
        frame.setVisible(true);
		
        for (int i = 0; i < LengthOfQuiz; i++) {
            usedIndexes[i] = -1; 
        }

		nextQuestion();
	}
    
    
    //Metoda odpowiedzialna za wyswietlanie Pytan i przyciskow
    public void nextQuestion(){
        if (currentIndex >= LengthOfQuiz) {
            displayResults();
        } else {
            index = random.nextInt(questions.length);
            while (isIndexUsed(index)) {
                index = random.nextInt(questions.length);
            }
            poprawny_indeks = random.nextInt(4);
            usedIndexes[currentIndex] = index;
            currentIndex++;
            String temp_option = options[index][poprawny_indeks];
            options[index][poprawny_indeks] = options[index][0];
            options[index][0] = temp_option;

            textField.setText("Pytanie:" + (currentIndex));
            textarea.setText(questions[index]);
            buttonA.setText(options[index][0]);
            buttonB.setText(options[index][1]);
            buttonC.setText(options[index][2]);
            buttonD.setText(options[index][3]);
        }
    }
    //Metoda do wykorzystywana do unikania powtarzania sie pytan z zestawu
    private boolean isIndexUsed(int index) {
        for (int i : usedIndexes) {
            if (i == index) {
                return true;
            }
        }
        return false;
    }
    @Override
    //Metoda odpowiedzialna za akcje (klikniecie przycisku w tym przypadku)
    public void actionPerformed(ActionEvent e){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        //domyslnie poprawna odpowiedz to A ale uzytkownik tego nie wie >:)
        if(e.getSource()==buttonA){
           answer = options[index][0];
        }
        else if(e.getSource()==buttonB){
            answer = options[index][1];
        }
        else if(e.getSource()==buttonC){
            answer = options[index][2];
        }
        else if(e.getSource()==buttonD){
            answer = options[index][3];
        }
        if(answer.equals(options[index][poprawny_indeks])){
            correctGuesses ++;
        }
        displayAnswer();
    }
    public void displayAnswer(){
        
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        JButton[] buttons = {buttonA, buttonB, buttonC, buttonD};

        for(int i = 0; i < buttons.length; i++)
        {
            if(buttons[i].getText() == options[index][poprawny_indeks]){
                buttons[i].setBackground(new Color(0x32C434));
            }
            else{
                buttons[i].setBackground(new Color(0xB52727));
            }
        }
        
        Timer pause = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                buttonA.setBackground(new Color(0x000C18));
                buttonB.setBackground(new Color(0x000C18));
                buttonC.setBackground(new Color(0x000C18));
                buttonD.setBackground(new Color(0x000C18));
            
                answer = " ";
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }    
        }
        );
        //wywolujemy pauze tylko raz po odpowiedzi na pytanie
        pause.setRepeats(false);
        pause.start();
    }
    public void displayResults(){
        frame.remove(centerPanel);
        bottomPanel.setVisible(true);
        
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(true);
        buttonD.setEnabled(false);

        menuButton1.setEnabled(false);
        menuButton2.setEnabled(false);
        menuButton3.setEnabled(false);
        menuButton4.setEnabled(false);
        
        result =  (double) correctGuesses / LengthOfQuiz * 100;
        String rounded = String.format("%.2f", result);
        double roundedResult = Double.parseDouble(rounded.replace(",", "."));
        textarea.setText("");
        textField.setText("Wynik Quizu");
        centerPanel.remove(buttonB);
        centerPanel.remove(buttonD);
        buttonA.setBackground(new Color(0x32C434));
        buttonA.setText(correctGuesses + "/" + LengthOfQuiz + " answered correctly");
        buttonB.setText("");
        buttonC.setText("Next Quiz ?");
        buttonD.setText("");
        


        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Quiz quizik = new Quiz();
            }
        });

        
        frame.add(correctAns);
        frame.add(corrPercentage);
    }
}
