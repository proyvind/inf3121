PAPER=report
LOCALLATEX = ../../latex
TEX = TEXINPUTS=./:$(LOCALLATEX):$(TEXINPUTS) pdflatex -interaction nonstopmode -halt-on-error

all: $(PAPER).pdf

clean:
	rm -fv $(PAPER).aux $(PAPER).log $(PAPER).dvi $(PAPER).pdf

$(PAPER).pdf: $(PAPER).tex
	$(TEX) $(PAPER) 
