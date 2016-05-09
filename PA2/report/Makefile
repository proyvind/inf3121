PAPER=report
LOCALLATEX = ../../latex
LATEXCLASSES = $(LOCALLATEX)/ifi-kompendium-forside-eng.png $(LOCALLATEX)/ifikompendium.tex $(LOCALLATEX)/ifikompendiumforside.sty $(LOCALLATEX)/rtm.sty $(LOCALLATEX)/tikz-uml.sty
TEX = TEXINPUTS=./:$(LOCALLATEX):$(TEXINPUTS) pdflatex -interaction nonstopmode -halt-on-error

all: $(PAPER).pdf

clean:
	rm -fv $(PAPER).aux $(PAPER).dvi $(PAPER).log $(PAPER).out $(PAPER).pdf

$(PAPER).aux: $(PAPER).tex $(LATEXCLASSES)
	$(TEX) -draftmode $(PAPER)

$(PAPER).pdf: $(PAPER).tex $(PAPER).aux $(LATEXCLASSES)
	$(TEX) $(PAPER) 
