MF = /tmp/deqManifest

DEQ = deq.jar
SRCDIR = deq

JFLAGS = -g
JAVAC = javac -cp ./$(SRCDIR):${CLASSPATH}

.SUFFIXES: .java .class
.java.class:
	$(JAVAC) $(JFLAGS) $<

_DEQ_SRC = DeqApplet.java \
	DeqFrame.java \
	DeqPanel.java \
	DeqGui.java \
	Square.java \
	SquareView.java \
	SquareViewMouseHandler.java \
	Move.java

DEQ_SRC = $(_DEQ_SRC:%=$(SRCDIR)/%)

DEQ_CLASSES = $(DEQ_SRC:.java=.class)

$(DEQ):	$(DEQ_SRC) $(DEQ_CLASSES)
	rm -f $(MF)
	echo "Main-Class: $(SRCDIR)/DeqFrame" > $(MF)
	jar cmf $(MF) $@ $(SRCDIR)/*.class
	rm -f $(MF)

clean:
	rm -f $(DEQ) $(SRCDIR)/*.class
