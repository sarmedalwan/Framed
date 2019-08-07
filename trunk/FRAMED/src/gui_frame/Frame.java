package gui_frame;

import compute_similarities.PDF;
import compute_similarities.SortListOfPDFsAndCalculateSimilarities;
import compute_similarities.Spring;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.geom.Point3;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Camera;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerListener;
import org.graphstream.ui.view.ViewerPipe;
import pdf_tools.PdfManager;
import word_pdf_frequency.WordFrequencyCounter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

// class for JFrame
public class Frame extends JFrame implements MouseListener, ViewerListener, MouseWheelListener {
    final private String TITLE = "Framed";
    final private int WIDTH = 400;
    final private int HEIGHT = 200;
    protected boolean loop = true;
    private ViewPanel view ;
    private JPanel graphPanel,buttonPanel,gridButtonPanel;
    private JLabel labelButton;
    private JButton browseButton,resetButton,helpButton;
    public int calculatedSize;

    protected ButtonGroup ignoreOptions;

    ArrayList<PDF> pdfs;
    ArrayList<Spring> springs;

    static PdfManager manager = new PdfManager();
    // declare variables here...

    public Frame() {
        // instantiate components here...
        pdfs = new ArrayList<>();
        springs = new ArrayList<>();
        setLocationRelativeTo(null);
        buttonPanel = new JPanel();
        browseButton = new JButton("Browse");
        labelButton=new JLabel("Select The PDF Folder");
        browseButton.addActionListener((actionEvent)->{
            createChooser();
        });
        helpButton = new JButton( "Help");
        helpButton.addActionListener((actionEvent)->{
            JOptionPane.showMessageDialog(null, "A larger distance between two PDFs indicates that there is less similarity between them" +
                    "\nA smaller distance between two PDFs indicates that there is more similarity between them" +
                    "\nZoom with the scroll wheel, centre the zoom with the cursor" +
                    "\nHold right click to move a PDF around on the graph" +
                    "\nLeft click on a PDF to open it" +
                    "\nClick the Browse button and select the folder where your PDF files are to begin"+
                    "\nIt is recommended to use 500 Ignored Words for a balanced analysis");
        });
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel browsePanel = new JPanel(new FlowLayout());
        JPanel helpPanel = new JPanel(new FlowLayout());
        JPanel labelPanel = new JPanel(new FlowLayout());
        JPanel ignoreOptionsPanel = createIgnoreOptionsButtonPanel();

        gridButtonPanel = new JPanel(new GridLayout(2,2));
        browsePanel.add(browseButton);
        helpPanel.add(helpButton);
        labelPanel.add(labelButton);
        gridButtonPanel.add(browsePanel);
        gridButtonPanel.add(labelPanel);
        gridButtonPanel.add(helpPanel);
        gridButtonPanel.add(ignoreOptionsPanel);
        buttonPanel.add(gridButtonPanel);
        add(buttonPanel, BorderLayout.CENTER);
        addMouseListener(this);
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    //Generate Chooser
    public void createChooser(){
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("open file " +
                    chooser.getSelectedFile().getName());
            if (manager.getListOfPdfFilesInFolder(chooser.getSelectedFile().getPath()).isEmpty()){
                JOptionPane.showMessageDialog(null,"The Folder Has no PDF Files");
            }
            else {
            displaySimilaritiesForFilesInFolder(chooser.getSelectedFile().getPath());
            int numberOfNodes=1+pdfs.size();
            browseFunctions(numberOfNodes);
            }
        }
    }
    //Browse button Functionalities
    public void browseFunctions(int count){
        calculatedSize=(int)(300+80*Math.log(count));
        setSize(new Dimension(calculatedSize,calculatedSize));
        buttonPanel.remove(gridButtonPanel);
        add(buttonPanel,BorderLayout.SOUTH);
        setResetButton();
        buttonPanel.add(resetButton);
        view.setSize(getSize());
        this.add(view);
        this.add(graphPanel);

        graphPanel.setVisible(true);
    }
    //Create Reset button
    private void setResetButton(){
        resetButton=new JButton("Reset");
        resetButton.addActionListener(e -> {
            new Frame();
            this.dispose();
        });
    }

    protected JPanel createIgnoreOptionsButtonPanel(){
        JPanel buttonPanel = new JPanel(new BorderLayout());
        JRadioButton noIgnoringOfWords = new JRadioButton("Do not ignore words");
        noIgnoringOfWords.setActionCommand("no ignoring");
        JRadioButton ignoreSmallAmountOfWords = new JRadioButton("Ignore 500 words");
        ignoreSmallAmountOfWords.setActionCommand("ignore 500");
        JRadioButton ignoreBigAmountOfWords = new JRadioButton("Ignore 5000 words");
        ignoreBigAmountOfWords.setActionCommand("ignore 5000");

        buttonPanel.add(noIgnoringOfWords, BorderLayout.NORTH);
        buttonPanel.add(ignoreSmallAmountOfWords, BorderLayout.CENTER);
        buttonPanel.add(ignoreBigAmountOfWords, BorderLayout.SOUTH);

        initalizeIgnoreOptions(buttonPanel.getComponents());

        return buttonPanel;
    }

    protected void initalizeIgnoreOptions(Component[] ignoreButtons){
        ignoreOptions = new ButtonGroup();
        for(Component component : ignoreButtons){
            JRadioButton button = (JRadioButton) component;
            ignoreOptions.add(button);
        }
    }


    private void createSprings(){
        for (int i = 0; i < pdfs.size(); i++) {
            HashMap<String, Double> similarities = pdfs.get(i).getSimilarities();
            for(Map.Entry<String, Double> entry : similarities.entrySet())
            {
                if(entry.getValue() > 0.05)
                {//Only create a spring between PDFs that are similar
                    springs.add(new Spring(pdfs.get(i), manager.getPdfByName(pdfs,entry.getKey()), entry.getValue()));
                }
            }
        }
    }

    public String getIgnoredWordsFilePath(){
        ButtonModel ignoreOptionSelected = ignoreOptions.getSelection();

        if(ignoreOptionSelected != null) {
            String ignoreOption = ignoreOptionSelected.getActionCommand();
            switch(ignoreOption){
                case "no ignoring":
                    return null;
                case "ignore 500":
                    return "src/resources/500CommonWords.csv";
                case "ignore 5000":
                    return "src/resources/5000CommonWords.csv";
            }

        }

        return null;
    }

    public void displaySimilaritiesForFilesInFolder(String folderPath){
        ArrayList<PDF> pdfs = manager.getTextFromMultipleFiles(folderPath);
        WordFrequencyCounter counter = new WordFrequencyCounter();
        counter.calculateFrequenciesForMultiplePdfs(pdfs, getIgnoredWordsFilePath());

        ArrayList<PDF> pdfsWithSimilarities = SortListOfPDFsAndCalculateSimilarities.getSimilarities(pdfs);

        PDF pdf1 = pdfsWithSimilarities.get(0);
        System.out.println(pdf1.getName() + " has similarities: " + pdf1.getSimilarities().toString());
        PDF pdf2 = pdfsWithSimilarities.get(1);
        System.out.println(pdf2.getName() + " has similarities: " + pdf2.getSimilarities().toString());
        PDF pdf3 = pdfsWithSimilarities.get(2);
        System.out.println(pdf3.getName() + " has similarities: " + pdf3.getSimilarities().toString());


        this.pdfs = pdfsWithSimilarities;

        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");//org.graphstream.ui.view.Viewer
        Graph graph = new SingleGraph("FRAMED");
        graph.setStrict(false);
        graph.setAutoCreate( true );
        graph.addAttribute("ui.stylesheet", "node {text-background-mode : plain; shape: rounded-box; size : 50; fill-mode: image-scaled; fill-image: url('src/resources/icon.png'); }");
        for (PDF pdf : pdfsWithSimilarities)
        {

            Node first = graph.addNode(pdf.getName());
            first.setAttribute("ui.label",pdf.getName());
            first.setAttribute("layout.weight", 0.1);
            Iterator it = pdf.getSimilarities().entrySet().iterator();
            int count = 0;
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                pair.getValue();
                if((double)pair.getValue() > 0.0)
                    count += 1;
            }
            if(count == 0)
                first.setAttribute("ui.style","text-background-color : red;" );


            for(String name : pdf.getSimilarities().keySet()){
                Node second = graph.addNode(name);
                second.setAttribute("ui.label", name);
                second.setAttribute("layout.weight", 0.1);
                if(pdf.getSimilarities().get(name) > 0) {
                   Edge edge = graph.addEdge(pdf.getName()+name, first, second);
                   if(edge != null)
                   {
                       edge.setAttribute("layout.weight", 10-(10*pdf.getSimilarities().get(name)));
                       if(pdf.getSimilarities().get(name) == 1)
                       {
                           edge.setAttribute("ui.style","fill-color: rgb(" + 0 + "," + 255 + "," + 0 + ");" );
                       }
                   }
                }

            }
        }

        Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        //Viewer viewer = graph.display();
        viewer.enableAutoLayout();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
        ViewerPipe fromViewer = viewer.newViewerPipe();
        fromViewer.addViewerListener(this);
        fromViewer.addSink(graph);
        view = viewer.addDefaultView(false);   // false indicates "no JFrame".
        graphPanel = new JPanel();
        view.addMouseWheelListener(this);



        Thread thread = new Thread(() -> {
            while(loop) {
                fromViewer.pump();

            }
        });


        thread.start();
    }

    public static void main(String[] args){
       new Frame();
    }

    @Override
    public void buttonPushed(String id){
        PDF pdfToBeOpened = manager.getPdfByName(pdfs, id);
        manager.openPdfDocument(pdfToBeOpened);
        System.out.println(id);
        try {
            Thread.sleep(250);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public void buttonReleased(String id){
        System.out.println("button released on " + id);
    }

    @Override
    public void viewClosed(String id){
        loop = false;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        PDF clicked = null;
        for (int i = 0; i < pdfs.size(); i++) {
            if((mouseEvent.getX() > pdfs.get(i).getPosition().x && mouseEvent.getX() < pdfs.get(i).getPosition().x + PDF.ICON_WIDTH)&&
                    (mouseEvent.getY() > pdfs.get(i).getPosition().y && mouseEvent.getY() < pdfs.get(i).getPosition().y + PDF.ICON_HEIGHT)){
                clicked = pdfs.get(i);
            }
        }
        System.out.println(clicked);
        if(clicked != null) {
            manager.openPdfDocument(clicked);
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) { }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) { }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) { }

    @Override
    public void mouseExited(MouseEvent mouseEvent) { }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int wheelRotation = e.getWheelRotation();
        double zoom = Math.pow(1.5, wheelRotation);
        Camera camera = view.getCamera();
        zoom = camera.getViewPercent() * zoom;
        camera.setViewPercent(zoom);
        Point3 cameraCenter = camera.getViewCenter();
        Point3 pixelPoint = camera.transformGuToPx(cameraCenter.x,cameraCenter.y,0);
        double x = e.getX() - pixelPoint.x;
        double y = e.getY() - pixelPoint.y;
        x *= 0.5;
        y *= 0.5;
        Point3 newCenter = camera.transformPxToGu(x+pixelPoint.x,y+pixelPoint.y);
        camera.setViewCenter(newCenter.x, newCenter.y, 0);
    }
}

