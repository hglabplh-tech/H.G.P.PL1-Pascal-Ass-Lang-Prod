package hgp.lang.genCompile.langblocks;

import org.antlr.v4.runtime.Token;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FunctionBlock extends BlockClassBase implements Serializable, AutoCloseable {


    public FunctionBlock(Token token, boolean openBlock, String name) {
        super(token, openBlock, name);
    }

    public File writeMeToStream() throws IOException {
        File tempFile = File.createTempFile("FunctionBlock", ".obj");
        tempFile.deleteOnExit();
        try (ObjectOutputStream objOut = new
                ObjectOutputStream(new FileOutputStream(tempFile))) {
            objOut.writeObject(this);
            objOut.close();
        } catch (IOException | SecurityException e) {
            throw new RuntimeException(e);
        }
        return tempFile;
    }

    public void readMeFromStream(File tempFile) throws IOException {
        try (ObjectInputStream objOut = new
                ObjectInputStream(new FileInputStream(tempFile))) {
            objOut.readObject();
            objOut.close();
        } catch (IOException | SecurityException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {

    }


}
