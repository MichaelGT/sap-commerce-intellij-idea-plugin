/*
 * This file is part of "hybris integration" plugin for Intellij IDEA.
 * Copyright (C) 2014-2016 Alexander Bartash <AlexanderBartash@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.intellij.idea.plugin.hybris.flexibleSearch.completion;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.idea.plugin.hybris.flexibleSearch.FlexibleSearchLanguage;
import com.intellij.idea.plugin.hybris.flexibleSearch.psi.FlexibleSearchTableName;
import com.intellij.idea.plugin.hybris.completion.provider.ItemTypeCodeCompletionProvider;
import com.intellij.openapi.diagnostic.Logger;

import static com.intellij.patterns.PlatformPatterns.psiElement;
import static com.intellij.util.containers.ContainerUtil.newArrayList;
import static com.intellij.util.containers.ContainerUtil.newHashSet;

public class FlexibleSearchCompletionContributor extends CompletionContributor {

    private static final Logger LOG = Logger.getInstance(FlexibleSearchCompletionContributor.class);

    public FlexibleSearchCompletionContributor() {
//        // keywords
//        extend(
//            CompletionType.BASIC,
//            psiElement()
//                .withElementType(TokenSet.create(
//                    FlexibleSearchTypes.QUERY_SPECIFICATION,
//                    FlexibleSearchTypes.SET_QUANTIFIER))
//                .withLanguage(FlexibleSearchLanguage.getInstance()), 
//            new FSKeywordCompletionProvider(FSKeywords.keywords(), (keyword) ->
//                LookupElementBuilder.create(keyword)
//                                    .withCaseSensitivity(false)
//                                    .withIcon(AllIcons.Nodes.Function))
//        );

        extend(
            CompletionType.BASIC,
            psiElement()
                .inside(FlexibleSearchTableName.class)
                .withLanguage(FlexibleSearchLanguage.getInstance()),
            ItemTypeCodeCompletionProvider.getInstance()
        );


    }
}