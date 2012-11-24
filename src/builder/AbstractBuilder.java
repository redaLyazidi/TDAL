package builder;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public abstract class AbstractBuilder implements StatementBuilder {

	protected StringBuilder statement = new StringBuilder();


	@Override
	public void reset() {
		statement.delete(0, statement.length());
	}

	public StringBuilder getStatement() {
		return statement;
	}

	@Override
	public String toString() {
		return statement.toString();
	}

	@Override
	public void addParagraph(String s) {
		beginParagraph();
		addStatement(s);
		endParagraph();
	}

	@Override
	public void addLineFeed(int nb) {
		if(! (nb > 0)) {
			for (int i =0; i < nb ; i++)
				addLineFeed();
		}
	}

	@Override
	public void setTabulation(int nb) {
		for (int i =0; i < nb ; i++)
			setTabulation();
	}

	@Override
	public void writeToFileNIOWay2(String file) throws IOException {
		writeToFileNIOWay2(new File(file));
	}
	
	@Override
	public void writeToFileNIOWay2(File file) throws IOException {
		final byte[] messageBytes = statement.toString().getBytes(Charset.forName("UTF-8"));
		final long appendSize = messageBytes.length;
		final RandomAccessFile raf = new RandomAccessFile(file, "rw");
		raf.seek(raf.length());
		final FileChannel fc = raf.getChannel();
		final MappedByteBuffer mbf = fc.map(FileChannel.MapMode.READ_WRITE, fc.
				position(), appendSize);
		fc.close();
		mbf.put(messageBytes);
		raf.close();		
	}
}
