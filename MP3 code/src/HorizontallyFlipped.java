import java.util.ArrayList;

/*this is a class that flips the TextBlock field horizontally */
public class HorizontallyFlipped implements TextBlock {
    TextLine[] HorizFlipBlock;

    /* Truncated constructor */
    public HorizontallyFlipped(TextBlock TBInput) {
        this.HorizFlipBlock = new TextLine[TBInput.height()];
        for (int i = 0; i < TBInput.height(); i++) {// for each row in the input TextBlock
            try {
                this.HorizFlipBlock[i] = new TextLine(TBInput.row(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String row(int i) throws Exception {
        if (i > this.height()) {
            throw new Exception("Invalid row " + i);
        } else {
            return this.HorizFlipBlock[i].line;
        }
    }// row

    public int height() {
        return this.HorizFlipBlock.length;
    }// height

    public int width() {
        int maxLength = 0;
        for (int i = 0; i < this.height(); i++) {
            try {
                if (this.row(i).length() > maxLength) {
                    maxLength = this.row(i).length();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return maxLength;// return the width of the widest line as this is the block's width;
    }// width

    /*
     * HorizFlipper is a method that refers to a HorizontallyFlipped object, and
     * flips the
     * object's rows
     */
    public TextBlock HorizFlipper() {
        for (int i = 0; i < this.height(); i++) {
            try {
                StringBuilder s = new StringBuilder(this.row(i));// get the string of the row
                s.reverse();// flip the string
                this.HorizFlipBlock[i] = new TextLine(s.toString());// set the TextLine at row i to be the flipped line
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;// return the object
    }

    /*
     * getChildren method for HorizontallyFlipped. This adds null, as centered
     * cannot have
     * children
     */
    public ArrayList<TextBlock> getChildren() {
        ArrayList<TextBlock> returnArr = new ArrayList<>();
        returnArr.add(this);
        return returnArr;
    }
}
