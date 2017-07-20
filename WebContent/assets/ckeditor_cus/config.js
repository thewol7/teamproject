/**
 * @license Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here.
	// For complete reference see:
	// http://docs.ckeditor.com/#!/api/CKEDITOR.config

	// The toolbar groups arrangement, optimized for a single toolbar row.
	config.toolbarGroups = [
		{ name: 'document',	   groups: [ 'mode', 'document', 'doctools' ] },
		{ name: 'clipboard',   groups: [ 'clipboard', 'undo' ] },
		{ name: 'editing',     groups: [ 'find', 'selection', 'spellchecker' ] },
		{ name: 'forms' },
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'paragraph',   groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ] },
		{ name: 'links' },
		{ name: 'insert' },
		{ name: 'styles' },
		{ name: 'colors' },
		{ name: 'tools' },
		{ name: 'others' }
		/*{ name: 'about' }*/
	];

	// The default plugins included in the basic setup define some buttons that
	// are not needed in a basic editor. They are removed here.
	config.removeButtons = 'Cut,Copy,Paste,Undo,Redo,Anchor,Underline,Strike,Subscript,Superscript,Image';

	// Dialog windows are also simplified.
	config.removeDialogTabs = 'link:advanced';
	
	config.enterMode = CKEDITOR.ENTER_BR;
	config.height ='400px';
	config.font_defaultLabel='나눔고딕';
	config.font_names="나눔고딕/나눔고딕,Nanum Gothic,ng;굴림/굴림,Gulim;바탕/바탕,Batang; Arial/Arial";
	config.fontSize_sizes='8/8px;9/9px;10/10px;11/11px;12/12px;13/13px; 14/14px;16/16px;18/18px;20/20px;22/22px;24/24px;26/26px;28/28px;36/36px;48/48px;';
	config.fontSize_defaultLabel='15px';
	config.uiColor= '#f56a6a';
	config.extraPlugins = 'soundPlayer';
	config.extraPlugins = 'uploadcare';
};
